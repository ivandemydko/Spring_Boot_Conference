package one.persistence.entity;



import javax.persistence.*;
import java.util.Objects;

@Entity()
@Table(name = "users")
@DiscriminatorValue("S")
public class Speaker extends User {

    private Integer rating;
    private Integer bonuses;

    public Speaker(String name, String surname, String email, String password, Position position, Language language, Integer rating, Integer bonuses) {
        super(name, surname, email, password, position, language);
        this.rating = rating;
        this.bonuses = bonuses;
    }

    public Speaker() {
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getBonuses() {
        return bonuses;
    }

    public void setBonuses(Integer bonuses) {
        this.bonuses = bonuses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Speaker speaker = (Speaker) o;
        return rating.equals(speaker.rating);
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rating);
    }

}


