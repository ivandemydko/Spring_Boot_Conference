package one.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String language;

    public Language(String language) {
        this.language = language;
    }

    public Language() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language1 = (Language) o;
        return Objects.equals(id, language1.id) &&
                Objects.equals(language, language1.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language);
    }
}
