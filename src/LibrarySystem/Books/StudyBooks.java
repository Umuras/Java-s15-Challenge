package LibrarySystem.Books;

import LibrarySystem.Enums.BookType;
import Users.Author;

//Calculus, Fundamentals of Physics tarzı ders kitapları
public class StudyBooks extends Book{

    public StudyBooks(Long bookID, Author author, String name, Double price, Double edition) {
        super(bookID, author, name, price, edition);
        setBookType(BookType.STUDY);
    }
}
