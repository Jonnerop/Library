package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ebook")
public class EBook extends Book {
    @Column(name = "downloadlink")
    private String downloadlink;

    public String getDownloadlink() { return downloadlink; }
    public void setDownloadlink(String downloadlink) { this.downloadlink = downloadlink; }

    public String toString() {
        return "EBook{" +
               "id=" + getId() +
               ", title='" + getTitle() + '\'' +
               ", author=" + getAuthor() +
               ", downloadlink='" + downloadlink + '\'' +
               '}';
    }
}
