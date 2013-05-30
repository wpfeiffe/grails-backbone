package org.arbfile

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.web.servlet.support.RequestContextUtils

class BooksapiController
{

    def list = {
        def result = [success: true]
        result.data = Book.list(params)
        result.count = result.data.size()
        render text: result.data as JSON, contentType: 'application/json', status: result.success ? 200 : 500
    }

    def show = {
        def data = retrieveRecord()
        render text: data.result as JSON, contentType: 'application/json', status: data.status
    }

    def create = {
        def result = [success: true]
        def status = 200
        Book book = jsonToBook(request.JSON)
        book.validate()
        if (book.hasErrors())
        {
            status = 500
            result.message = extractErrors(book).join(";")
            result.success = false
        }
        else
        {
            result.data = book.save(flush: true)
        }
        render text: result.data as JSON, contentType: 'application/json', status: status
    }

    def update = {
        Map data = retrieveRecord(params)
        if (data.result.success)
        {
            Book book =  jsonToBook(request.JSON)
            data.result.data = book
            book.validate()
            if (book.hasErrors())
            {
                data.status = 500
                data.result.message = extractErrors(data.result.data).join(";")
                data.result.success = false
            }
            else
            {
                book = book.save(flush: true)
                data.result.data = book
            }
        }
        render text: data.result.data as JSON, contentType: 'application/json', status: data.status
    }

    def delete = {
        def data = retrieveRecord(params)
        try
        {
            if (data.result.success)
            {
                data.result.data.delete(flush: true)
            }
        } catch (Exception e)
        {
            data.result.success = false
            data.result.message = e.message
            data.result.status = 500
        }
        render text: data.result.data as JSON, contentType: 'application/json', status: data.status
    }

    private retrieveRecord(params)
    {
        def result = [success: true]
        def status = 200
        Book book = Book.get(params.id)
        if (book)
        {
            result.data = book
        }
        else
        {
            result.success = false
            result.message = "Book with id=${params.id} not found"
            status = 404
        }

        [result: result, status: status]
    }

    private Book jsonToBook(JSONObject json)
    {
        Book book = new Book()
        book.coverImage = json.coverImage
        book.author = json.author
        book.keywords = json.keywords
        book.title = json.title
        book.releaseDate = new Date().parse("MM/dd/yyyy", json.releaseDate)
        return book
    }

    def messageSource

    private extractErrors(model)
    {
        def locale = RequestContextUtils.getLocale(request)
        model.errors.fieldErrors.collect { error ->
            messageSource.getMessage(error, locale)
        }
    }
}
