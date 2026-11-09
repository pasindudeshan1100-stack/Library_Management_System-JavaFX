package Model;

import java.time.LocalDate;

public class BookHistoryDTO {
    private String book_id;
    private String member_id;
    private String book_title;
    private LocalDate issue_date;
    private  LocalDate due_date;
    private  LocalDate return_date;
    private  String status;

    public BookHistoryDTO() {
    }

    public BookHistoryDTO(String memberId, String bookId, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate, String status) {

    }

    public BookHistoryDTO(String book_id, String member_id, String book_title, LocalDate issue_date, LocalDate due_date, LocalDate return_date, String status) {
        this.book_id = book_id;
        this.member_id = member_id;
        this.book_title = book_title;
        this.issue_date = issue_date;
        this.due_date = due_date;
        this.return_date = return_date;
        this.status = status;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public LocalDate getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(LocalDate issue_date) {
        this.issue_date = issue_date;
    }

    public LocalDate getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
