package LibrarySystem.Members;

import LibrarySystem.Books.Book;
import LibrarySystem.Enums.MemberType;
import Users.Reader;

import java.time.LocalDateTime;
import java.util.*;

public abstract class MemberRecord extends Reader {
    private Long memberID;
    private MemberType type;
    private LocalDateTime dateOfMemberShip;
    private boolean noBooksIssued;
    private final int MAX_BOOK_LIMIT = 5;
    private String name;
    private String address;
    private String phoneNo;
    private boolean verifiedMemberStatus;
    private int issueBookValue = 0;
    private double memberBalance = 1000.0;
    private Map<Long,StringBuilder> billList;
    public static Long stmemberID = 1L;

    public MemberRecord(Long memberID, MemberType type, String name, String address, String phoneNo)
    {
        super(name);
        this.memberID = stmemberID;
        this.type = type;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        noBooksIssued = false;
        billList = new HashMap<>();
        stmemberID++;
    }

    public Long getMemberID()
    {
        return memberID;
    }

    public MemberType getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhoneNo()
    {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    public boolean getNoBooksIssued()
    {
        return noBooksIssued;
    }

    public void setNoBooksIssued(boolean noBooksIssued)
    {
        this.noBooksIssued = noBooksIssued;
    }

    public boolean getVerifiedMemberStatus()
    {
        return verifiedMemberStatus;
    }

    public void setVerifiedMemberStatus(boolean verifiedMemberStatus)
    {
        this.verifiedMemberStatus = verifiedMemberStatus;
    }

    public int getIssueBookValue()
    {
        return issueBookValue;
    }

    public void setIssueBookValue(int issueBookValue)
    {
        this.issueBookValue += issueBookValue;
    }

    public Map<Long,StringBuilder> getBillList()
    {
        return billList;
    }

    public void addBillInBillList(StringBuilder billBuilder, Long bookID)
    {
        billList.put(bookID,billBuilder);
    }

    public void removeBillInBillList(Long bookID)
    {
        billList.remove(bookID);
    }

    public double getMemberBalance()
    {
        return memberBalance;
    }

    public void addMemberBalance(double memberBalance)
    {
        this.memberBalance += memberBalance;
    }

    public abstract MemberRecord getMember();

    public abstract void incrementBookIssued();

    public abstract void decrementBookIssued();

    public abstract void payBill(Book book);

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }

        if(obj == null || this.getClass() != obj.getClass())
        {
            return false;
        }

        MemberRecord member = (MemberRecord) obj;
        return this.memberID == member.getMemberID() && this.name.equals(member.getName());
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(this.memberID);
    }
}
