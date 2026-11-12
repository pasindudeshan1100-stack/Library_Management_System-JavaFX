package Model;

import java.time.LocalDate;

public class IssueBookDTO {
        private String issueId;
        private String bookId;
        private  String memberId;
        private LocalDate issueDate;
        private  LocalDate DueDate;


    public IssueBookDTO(String issueId) {
        this.issueId = issueId;
    }

    public IssueBookDTO() {
    }

    public IssueBookDTO(String bookId, String memberId, LocalDate issueDate, LocalDate dueDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.DueDate = dueDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return DueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        DueDate = dueDate;
    }
    
    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }
}
