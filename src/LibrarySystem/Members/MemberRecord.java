package LibrarySystem.Members;

import LibrarySystem.Enums.MemberType;

import java.time.LocalDateTime;

public abstract class MemberRecord {
    private Long memberID;
    private MemberType type;
    private LocalDateTime dateOfMemberShip;
    private boolean noBooksIssued;
    private final int MAX_BOOK_LIMIT = 5;
    private String name;
    private String address;
    private String phoneNo;

    public MemberRecord(Long memberID, MemberType type, String name, String address, String phoneNo)
    {
        this.memberID = memberID;
        this.type = type;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        noBooksIssued = false;
    }

    public boolean getNoBooksIssued()
    {
        return noBooksIssued;
    }

    public void setNoBooksIssued(boolean noBooksIssued)
    {
        this.noBooksIssued =noBooksIssued;
    }

    public abstract Object getMember();

    public abstract void incrementBookIssued();

    public abstract void decrementBookIssued();

    public abstract void payBill();
}
