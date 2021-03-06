package Library.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
@Table(name = "borrowing")
public class BookBorrowing {


    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne
    private Book book;
    @Column (nullable = false)

    private LocalDate startTerm;

    private LocalDate endTerm;
    @ManyToOne
    private Reader reader;
    private String comment;

    public BookBorrowing(Book book, LocalDate startTerm, Reader reader) {

        this.book = book;
        this.startTerm = startTerm;
        this.endTerm = startTerm.plus(30, ChronoUnit.DAYS);
        this.reader = reader;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getStartTerm() {
        return startTerm;
    }

    public void setStartTerm(LocalDate startTerm) {
        this.startTerm = startTerm;
    }

    public LocalDate getEndTerm() {
        return endTerm;
    }

    public void setEndTerm(LocalDate endTerm) {
        this.endTerm = endTerm;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "id=" + id +
                ", book=" + book +
                ", startTerm=" + startTerm + '\'' +
                ", endTerm=" + endTerm + '\'' +
                ", comment='" + comment + '\'' +
                ", reader=" + reader +
                '}';
    }
}
