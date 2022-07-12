package com.mikaelsonbraz.bookservice.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long bookId;
    private String author;
    private String title;
    private Date launchDate;
    private BigDecimal price;
    private String currency;
    private String environment;

    public Book() {
    }

    public Book(Long bookId, String author, String title, Date launchDate, BigDecimal price, String currency, String environment) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.launchDate = launchDate;
        this.price = price;
        this.currency = currency;
        this.environment = environment;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(author, book.author) && Objects.equals(launchDate, book.launchDate) && Objects.equals(price, book.price) && Objects.equals(title, book.title) && Objects.equals(currency, book.currency) && Objects.equals(environment, book.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, author, launchDate, price, title, currency, environment);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author='" + author + '\'' +
                ", launchDate=" + launchDate +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", currency='" + currency + '\'' +
                ", environment='" + environment + '\'' +
                '}';
    }
}
