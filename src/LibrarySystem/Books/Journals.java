package LibrarySystem.Books;

import LibrarySystem.Enums.BookType;
import Users.Author;

//Akademik Dergiler
public class Journals extends Book{

    public Journals(Long bookID, Author author, String name, Double price, Double edition) {
        super(bookID, author, name, price, edition);
        setBookType(BookType.JOURNALS);
    }
}
