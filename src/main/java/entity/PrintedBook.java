package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "printedbook")
public class PrintedBook extends Book {
    private int pageCount;

    public int getPageCount() { return pageCount; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }

    public String toString() {
        return "PrintedBook{" +
               "id=" + getId() +
               ", title='" + getTitle() + '\'' +
               ", author=" + getAuthor() +
               ", pageCount=" + pageCount +
               '}';
    }
}
