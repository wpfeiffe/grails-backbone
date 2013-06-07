import org.arbfile.Book

class BootStrap
{

    def init = { servletContext ->
        Book book = new Book(title:"Rapid Development", author:"Steve McConnell", releaseDate:new Date().parse("MM/dd/yyyy", "05/01/2004"), keywords: "code practic", coverImage:"/grails-backbone/static/images/book.png")
        book.save()
        book = new Book(title:"Domain Driven Design", author:"Evans", releaseDate:new Date().parse("MM/dd/yyyy", "05/01/2010"), keywords: "domain", coverImage:"/grails-backbone/static/images/book.png")
        book.save()
        book = new Book(title:"Refactoring", author:"Martin Fowler", releaseDate:new Date().parse("MM/dd/yyyy", "05/01/2007"), keywords: "refactoring java", coverImage:"/grails-backbone/static/images/book.png")
        book.save()
    }
    def destroy = {
    }
}
