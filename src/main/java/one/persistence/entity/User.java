package one.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Inheritance
@DiscriminatorColumn(
        name = "discriminator",
        discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue(value = "U")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @JoinColumn(name = "position")
    @ManyToOne(fetch = FetchType.EAGER)
    private Position position;
    @JoinColumn(name = "language")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Language language;
    @ManyToMany(mappedBy = "userList",fetch = FetchType.EAGER)
    private Set<Report> reportList = new HashSet<>();

    public User(String name, String surname, String email, String password, Position position, Language language) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.position = position;
        this.language = language;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Set<Report> getReportList() {
        return reportList;
    }

    public void setReportList(Set<Report> reportList) {
        this.reportList = reportList;
    }

    public void addReport(Report report) {
        reportList.add(report);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                name.equals(user.name) &&
                surname.equals(user.surname) &&
                email.equals(user.email) &&
                position.equals(user.position) &&
                language.equals(user.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, position, language);
    }
}

