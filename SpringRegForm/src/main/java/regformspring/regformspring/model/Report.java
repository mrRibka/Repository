package regformspring.regformspring.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String description;
    @Column
    private String email;
    @Column
    private String author;
    @Column
    @Enumerated(value = EnumType.STRING)
    private ReportStatus status;
    @Column
    @Enumerated(value = EnumType.STRING)
    private Type type;
    @Column
    private LocalDate date;
    public Report() {
    }

    public Report(String description, Type type) {
        this.status = ReportStatus.SENT;
        this.date = LocalDate.now();
        this.description = description;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String authorFirstname, String authorLastname) {
        this.author = authorFirstname + " " + authorLastname;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
