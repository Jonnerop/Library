package dao;

import jakarta.persistence.EntityManager;
import entity.*;

public class LibraryDAO {

    private final EntityManager entityManager;

    public LibraryDAO(EntityManager entityManager) { this.entityManager = entityManager; }

    public Student createStudent(Student student) { entityManager.persist(student); return student; }
    public Student findStudent(Long studentId) { return entityManager.find(Student.class, studentId); }
    public Student updateStudent(Student student) { return entityManager.merge(student); }
    public void deleteStudent(Long studentId) {
        Student student = entityManager.find(Student.class, studentId);
        if (student != null) entityManager.remove(student);
    }

    public Book createBook(Book book) { entityManager.persist(book); return book; }
    public Book findBook(Long bookId) { return entityManager.find(Book.class, bookId); }
    public Book updateBook(Book book) { return entityManager.merge(book); }
    public void deleteBook(Long bookId) {
        Book book = entityManager.find(Book.class, bookId);
        if (book != null) entityManager.remove(book);
    }

    public BorrowedBook createBorrowedBook(BorrowedBook borrowedBook) { entityManager.persist(borrowedBook); return borrowedBook; }
    public BorrowedBook findBorrowedBook(Long borrowedBookId) { return entityManager.find(BorrowedBook.class, borrowedBookId); }
    public void deleteBorrowedBook(Long borrowedBookId) {
        BorrowedBook borrowedBook = entityManager.find(BorrowedBook.class, borrowedBookId);
        if (borrowedBook != null) entityManager.remove(borrowedBook);
    }
}
