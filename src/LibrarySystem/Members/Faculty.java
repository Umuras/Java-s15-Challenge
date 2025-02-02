package LibrarySystem.Members;

import LibrarySystem.Books.Book;
import LibrarySystem.Enums.MemberType;

public class Faculty extends MemberRecord{
    public Faculty(Long memberID, MemberType type, String name, String address, String phoneNo) {
        super(memberID, type, name, address, phoneNo);
    }

    @Override
    public MemberRecord getMember() {
        return this;
    }

    @Override
    public void incrementBookIssued() {

    }

    @Override
    public void decrementBookIssued() {

    }

    @Override
    public double payBill(Book book) {
        return book.getPrice();
    }
}
