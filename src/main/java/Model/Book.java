package Model;

public class Book {
    private String bookid;
    private  String title;
    private  String author;
    private String  category;
    private  String  year;
    private  String quantity;

    public Book() {
    }

    public Book(String bookid, String title, String author, String category, String year, String quantity) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
