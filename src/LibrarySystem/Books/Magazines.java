package LibrarySystem.Books;

import LibrarySystem.Enums.BookType;
import Users.Author;

//National Geographic, Time, The Economist tarzı dergiler
public class Magazines extends Book{
    public Magazines(Long bookID, Author author, String name, Double price, Double edition) {
        super(bookID, author, name, price, edition);
        setBookType(BookType.MAGAZINES);
    }
}
