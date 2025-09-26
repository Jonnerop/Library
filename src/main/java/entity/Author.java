package entity;

import jakarta.persistence.*;

@Entity
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String toString() {
        return "Author{id=" + id + ", name='" + name + "'}";
    }
}
