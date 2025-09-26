package entity;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "borrowedbook")
public class BorrowedBook {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "borrowDate", nullable = false)
    private LocalDate borrowDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public BorrowedBook() {}
    public BorrowedBook(Student student, Book book, LocalDate borrowDate) {
        this.student = student; this.book = book; this.borrowDate = borrowDate;
    }

    public Long getId() { return id; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public void setBorrowDate(LocalDate borrowDate) { this.borrowDate = borrowDate; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public String toString() {
        return "BorrowedBook{id=" + id + ", borrowDate=" + borrowDate +
               ", book=" + book +
               ", student=" + student + "}";
    }
}
