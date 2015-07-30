package lab05.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@XmlRootElement
@Component
@Entity
@Table(name="Book")
public class Book implements Serializable{

    private static final long serialVersionUID = 1213213232L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @NotEmpty
    private String title;

    public Book() {
        /* Needed for JPA*/
        super();
    }

    public Book(String title) {
        /* Needed for Insert JDBCTemplate*/
        super();
        this.title = title;
    }

    public Book(Long id, String title) {
        /* Needed for List Book*/
        super();
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + "]";
    }
}
