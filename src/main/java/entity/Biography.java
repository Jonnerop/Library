package entity;

import jakarta.persistence.*;

@Entity
public class Biography {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String details;

    @OneToOne(optional = false)
    @JoinColumn(name = "author_id", unique = true, nullable = false)
    private Author author;

    public Long getId() { return id; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public String toString() {
        return "Biography{id=" + id + ", details='" + details + "'}";
    }
}
