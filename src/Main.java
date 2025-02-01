import LibrarySystem.Books.*;
import LibrarySystem.Enums.BookType;
import LibrarySystem.Library;
import Users.Author;
import Users.Reader;

import java.security.Key;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to KUCUR Library");
        Scanner scanner = new Scanner(System.in);

        List<Book> libraryBooks = new ArrayList<>();
        Set<Author> libraryBooksAuthor = new HashSet<>();
        List<Reader> libraryReaders = new ArrayList<>();
        Library library = new Library(libraryBooks, libraryReaders,libraryBooksAuthor);

        libraryReaders.add(new Reader("Ali Umur Kucur"));

        Author omerSeyfettinAuthor = library.checkAuthor("Ömer Seyfettin");
        Book book1 = new StoryBooks(Book.stbookID,omerSeyfettinAuthor,"Forsa", 50.0,1.0);
        omerSeyfettinAuthor.addNewBook(book1);
        library.addNewBookInLibraryBooks(book1);
        library.addLibraryBooksAuthor(omerSeyfettinAuthor);

        Author muratSertogluAuthor = library.checkAuthor("Murat Sertoğlu");
        Book book2 = new StoryBooks(Book.stbookID, muratSertogluAuthor, "Battal Gazi", 150.0,1.0);
        muratSertogluAuthor.addNewBook(book2);
        library.addNewBookInLibraryBooks(book2);
        library.addLibraryBooksAuthor(muratSertogluAuthor);

        Author fyodorDostoevskyAuthor = library.checkAuthor("Fyodor Dostoevsky");
        Book book3 = new StoryBooks(Book.stbookID,fyodorDostoevskyAuthor,"Suç ve Ceza",200.0,4.0);
        fyodorDostoevskyAuthor.addNewBook(book3);
        library.addNewBookInLibraryBooks(book3);
        library.addLibraryBooksAuthor(fyodorDostoevskyAuthor);

        Author ferencMolnarAuthor = library.checkAuthor("Ferenc Molnar");
        Book book4 = new StoryBooks(Book.stbookID,ferencMolnarAuthor,"Pal Sokağı Çocukları", 95.0,2.0);
        ferencMolnarAuthor.addNewBook(book4);
        library.addNewBookInLibraryBooks(book4);
        library.addLibraryBooksAuthor(ferencMolnarAuthor);

        Book book5 = new StoryBooks(Book.stbookID,omerSeyfettinAuthor, "Pembe İncili Kaftan", 35.0,1.0);
        omerSeyfettinAuthor.addNewBook(book5);
        library.addNewBookInLibraryBooks(book5);

        Author nihalAtsizAuthor = library.checkAuthor("Nihal Atsız");
        Book book6 = new StoryBooks(Book.stbookID,nihalAtsizAuthor, "Bozkurtlar",325.0,5.0);
        nihalAtsizAuthor.addNewBook(book6);
        library.addNewBookInLibraryBooks(book6);
        library.addLibraryBooksAuthor(nihalAtsizAuthor);

        Book book7 = new StoryBooks(Book.stbookID,nihalAtsizAuthor,"Deli Kurt",180.0,3.0);
        nihalAtsizAuthor.addNewBook(book7);
        library.addNewBookInLibraryBooks(book7);


        while (true)
        {
            System.out.println("Kütüphaneye yeni kitap eklemek için 1'e basınız: ");
            System.out.println("Kütüphaneden kitap seçmek için 2'ye basınız: ");
            System.out.println("Kütüphanedeki tüm kitapları listelemek için 3'e basınız: ");
            System.out.println("Kütüphanedeki kitapları kategori türüne göre listelemek için 4'ya basınız: ");
            System.out.println("Kütüphanedeki bir yazara ait tüm kitaplara listelemek için 5'ye basınız: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    String authorName, name;
                    double price, edition;
                    System.out.println("Enter the book's author name: ");
                    authorName = scanner.nextLine();
                    System.out.println("Enter the book's name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter the book's price: ");
                    price = scanner.nextDouble();
                    System.out.println("Enter the book's edition: ");
                    edition = scanner.nextDouble();
                    Author newAuthor = library.checkAuthor(authorName);
                    System.out.println("Kategori seçiniz: 1-Journals, 2-Magazines, 3-Story, 4-Study");
                    int category = scanner.nextInt();
                    Book newBook;
                    if(category == 1)
                    {
                        newBook = new Journals(Book.stbookID,newAuthor,name,price,edition);
                    } else if (category == 2) {
                        newBook = new Magazines(Book.stbookID,newAuthor,name,price,edition);
                    } else if (category == 3) {
                        newBook = new StoryBooks(Book.stbookID,newAuthor,name,price,edition);
                    } else if (category == 4) {
                        newBook = new StudyBooks(Book.stbookID,newAuthor,name,price,edition);
                    }else{
                        System.out.println("Yanlış kategori seçimi yaptınız!!");
                        continue;
                    }
                    library.addNewBookInLibraryBooks(newBook);
                    library.addLibraryBooksAuthor(newAuthor);
                    newAuthor.addNewBook(newBook);
                    System.out.println("Librarye yeni kitap ekledin.");
                    break;
                case 2:
                    System.out.println("Id'ye göre seçim yapmak için 1'e basınız: ");
                    System.out.println("İsme göre seçim yapmak için 2'ye basınız: ");
                    System.out.println("Yazara göre seçim yapmak için 3'e basınız: ");
                    int choiceType = scanner.nextInt();
                    Book selectedBook = null;
                    scanner.nextLine();
                    if(choiceType == 1)
                    {
                        System.out.println("Kitap seçmek için bir id giriniz: ");
                        int bookId = scanner.nextInt();
                        selectedBook = library.searchBookId(bookId);
                    }else if(choiceType == 2)
                    {
                        System.out.println("Kitap seçmek için bir isim giriniz: ");
                        String bookName = scanner.nextLine();
                        selectedBook = library.searchBookName(bookName);
                    }else if(choiceType == 3)
                    {
                        System.out.println("Kitap seçmek için bir yazar adı giriniz: ");
                        String authorNm = scanner.nextLine();
                        List<Book> booksOfAuthor = library.searchBookAuthorName(authorNm);
                        if(!booksOfAuthor.isEmpty() && booksOfAuthor != null)
                        {
                            System.out.println("Kitabın id numarası üzerinden bir kitap seçiniz: ");
                            int bookId = scanner.nextInt();
                            for(Book book : booksOfAuthor)
                            {
                                if(book.getBookID() == bookId)
                                {
                                    selectedBook = book;
                                }
                            }
                        }
                    }else{
                        System.out.println("Yanlış seçim yaptınız!!");
                    }

                    if(selectedBook != null)
                    {
                        System.out.println("Seçili kitabı sistemden silmek için 1'e basınız: ");
                        System.out.println("Seçili kitabı güncellemek için 2'ye basınız: ");
                        System.out.println("Ana menüye dönmek için 3'e basınız: ");
                        int deleteOrUpdate = scanner.nextInt();

                        if(deleteOrUpdate == 1)
                        {
                            library.removeBookInLibraryBooks(selectedBook);
                        }else if(deleteOrUpdate == 2)
                        {
                            int updatingChoice = 0;
                            while(updatingChoice != 9)
                            {
                                System.out.println("Kitabın adını güncellemek için 1'e basınız: ");
                                System.out.println("Kitabın yazarını güncellemek için 2'ye basınız: ");
                                System.out.println("Kitabın fiyatını güncellemek için 3'e basınız: ");
                                System.out.println("Kitabın baskısını güncellemek için 4'e basınız: ");
                                System.out.println("Ana menüye dönmek için 9'a basınız: ");
                                updatingChoice = scanner.nextInt();
                                scanner.nextLine();

                                if(updatingChoice == 1)
                                {
                                    System.out.println("Kitabın adını giriniz: ");
                                    String updateBookName = scanner.nextLine();
                                    selectedBook.setName(updateBookName);
                                }else if(updatingChoice == 2)
                                {
                                    System.out.println("Kitabın yazarın adını giriniz: ");
                                    String updateAuthorName = scanner.nextLine();
                                    selectedBook.getAuthor().getAuthorBooks().remove(selectedBook);
                                    selectedBook.setAuthor(new Author(updateAuthorName));
                                    selectedBook.getAuthor().addNewBook(selectedBook);
                                    library.addLibraryBooksAuthor(selectedBook.getAuthor());
                                }else if(updatingChoice == 3)
                                {
                                    System.out.println("Kitabın fiyatını giriniz: ");
                                    Double updateBookPrice = scanner.nextDouble();
                                    selectedBook.setPrice(updateBookPrice);
                                }else if(updatingChoice == 4)
                                {
                                    System.out.println("Kitabın baskısını giriniz: ");
                                    Double updateBookEdition = scanner.nextDouble();
                                    selectedBook.setEdition(updateBookEdition);
                                }
                            }
                        } else if (deleteOrUpdate == 3) {
                            continue;
                        } else{
                            System.out.println("Yanlış seçim yaptınız");
                        }
                    }else{
                        System.out.println("Doğru seçim yapmadınız!!!");
                    }


                    break;
                case 3:
                    for (int i = 0; i < library.getLibraryBooks().size(); i++) {
                        library.getLibraryBooks().get(i).display();
                    }
                    break;
                case 4:
                    System.out.println("Kitapları listelemek için kategori seçiniz: 1-Journals, 2-Magazines, 3-Story, 4-Study");
                    int choiceCategory = scanner.nextInt();
                    List<Book> selectedCategoryBooks;
                    if(choiceCategory == 1)
                    {
                        selectedCategoryBooks = library.searchBookCategoryType(BookType.JOURNALS);

                    }else if(choiceCategory == 2)
                    {
                        selectedCategoryBooks = library.searchBookCategoryType(BookType.MAGAZINES);
                    }else if(choiceCategory == 3)
                    {
                        selectedCategoryBooks = library.searchBookCategoryType(BookType.STORY);
                    }else if(choiceCategory == 4)
                    {
                        selectedCategoryBooks = library.searchBookCategoryType(BookType.STUDY);
                    }else{
                        System.out.println("Yanlış kategori seçtiniz!!");
                        continue;
                    }
                    if(!selectedCategoryBooks.isEmpty() && selectedCategoryBooks != null)
                    {
                        selectedCategoryBooks.forEach(book -> book.display());
                    }else{
                        System.out.println("Kütüphanede bu kategoride kitap bulunamamaktadır!!!");
                    }
                    break;
                case 5:
                    System.out.println("Direk yazar adı girerek kitapları listelemek için 1'e basınız: ");
                    System.out.println("Kütüphanedeki kitapların tüm yazarlarını listeleyip yazarı seçip kitapları listelemek için 2'ye basınız: ");
                    int choiceAuthorOption = scanner.nextInt();
                    if(choiceAuthorOption == 1 || choiceAuthorOption == 2)
                    {
                        if(choiceAuthorOption == 2)
                        {
                            System.out.println(library.getLibraryBooksAuthors());
                            scanner.nextLine();
                        }
                        System.out.println("Yazara ait olan kitapları listelemek için yazarın adını giriniz: ");
                        String booksOfAuthorName = scanner.nextLine();
                        List<Book> booksOfAuthor = library.searchBookAuthorName(booksOfAuthorName);
                        if(!booksOfAuthor.isEmpty() && booksOfAuthor != null)
                        {
                            booksOfAuthor.forEach(book -> book.display());
                        }else{
                            System.out.println("Bu yazara ait kitap bulunmamaktadır.");
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}