package Model;

public class Book {
    private String bookid;
    private  String title;
    private  String author;
    private String  category;
    private Integer year;
    private  Integer quantity;



    public Book(String bookid, String title, String author, String category, Integer year, Integer quantity) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.category = category;
        this.year = year;
        this.quantity = quantity;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
