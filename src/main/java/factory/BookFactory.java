/* BookFactory.java
   Book factory class
   Author: Nomhle Ngengele 216227488
   Date: 16 March 2026
  
*/
package factory;

import domain.Book;

public class BookFactory
{
    public static Book createBook(String isbn, String title) {
        return new Book.Builder(isbn, title)
                .build();
    }

    public static Book createBook(String isbn,
                                  String title,
                                  String author,
                                  String subject,
                                  String publisher,
                                  int publicationYear) {
        return new Book.Builder(isbn, title)
                .author(author)
                .subject(subject)
                .publisher(publisher)
                .publicationYear(publicationYear)
                .build();
    }

}
