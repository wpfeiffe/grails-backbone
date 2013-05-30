package org.arbfile

class Book
{
    String title
    String author
    Date releaseDate
    String keywords
    String coverImage

    static expose = 'book'

    static constraints = {
        title(nullable: false, minSize: 2, maxSize: 160)
        author(nullable: false, minSize: 2, maxSize: 80)
        releaseDate(nullable: true)
        keywords(nullable: true, minSize: 2, maxSize: 200)
        coverImage(nullable: true, minSize: 2, maxSize: 200)
    }
}
