package LibrarySystem.Books;

import LibrarySystem.Enums.BookType;
import Users.Author;

public class StoryBooks extends Book{
    public StoryBooks(Long bookID, Author author, String name, Double price, Double edition) {
        super(bookID, author, name, price, edition);
        setBookType(BookType.STORY);
    }
}
