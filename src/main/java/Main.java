import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import dao.LibraryDAO;
import entity.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("LibraryPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        LibraryDAO libraryDAO = new LibraryDAO(entityManager);

        Author author = new Author();
        author.setName("Ursula K. Le Guin");
        entityManager.persist(author);

        Biography biography = new Biography();
        biography.setDetails("Author of science fiction & fantasy, young adult, and nonfiction");
        biography.setAuthor(author);
        entityManager.persist(biography);

        EBook eBook = new EBook();
        eBook.setTitle("The Left Hand of Darkness");
        eBook.setAuthor(author);
        eBook.setDownloadlink("https://amazon.com/left-hand-of-darkness");
        libraryDAO.createBook(eBook);

        PrintedBook printedBook = new PrintedBook();
        printedBook.setTitle("The Dispossessed");
        printedBook.setAuthor(author);
        printedBook.setPageCount(384);
        libraryDAO.createBook(printedBook);

        Student student1 = new Student();
        student1.setName("Jonne Roponen");
        libraryDAO.createStudent(student1);

        Student student2 = new Student();
        student2.setName("Ade Aiho");
        libraryDAO.createStudent(student2);

        BorrowedBook borrowedBook1 = new BorrowedBook(student1, eBook, LocalDate.now());
        BorrowedBook borrowedBook2 = new BorrowedBook(student2, printedBook, LocalDate.now().minusDays(3));
        libraryDAO.createBorrowedBook(borrowedBook1);
        libraryDAO.createBorrowedBook(borrowedBook2);

        entityManager.getTransaction().commit();

        System.out.println("Inserted author: " + author.getName());
        System.out.println("Inserted biography (details): " + biography.getDetails());
        System.out.println("Inserted books: " + eBook.getTitle() + " and " + printedBook.getTitle());
        System.out.println("Inserted students: " + student1.getName() + " and " + student2.getName());
        System.out.println("Borrow record: " + borrowedBook1.getStudent().getName() + " borrowed '" + borrowedBook1.getBook().getTitle() + "' on " + borrowedBook1.getBorrowDate());
        System.out.println("Borrow record: " + borrowedBook2.getStudent().getName() + " borrowed '" + borrowedBook2.getBook().getTitle() + "' on " + borrowedBook2.getBorrowDate());
    }
}
