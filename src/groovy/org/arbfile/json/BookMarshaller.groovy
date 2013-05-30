package org.arbfile.json

import grails.converters.JSON

import org.arbfile.Book

class BookMarshaller
{
    void register () {
        JSON.registerObjectMarshaller(Book) {
            Book book ->
                def returnValue =  [
                    id: book.id,
                    title: book.title,
                    author: book.author,
                    releaseDate: book.releaseDate.format('MM-dd-yyyy'),
                    keywords: book.keywords,
                    coverImage: book.coverImage
                ]

                return returnValue
        }
    }
}
