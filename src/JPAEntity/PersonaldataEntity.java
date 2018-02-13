package JPAEntity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "personaldata", schema = "public", catalog = "khgmqurw")
public class PersonaldataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpersonaldata;
    private String name;
    private String surname;
    private String born;
    private String death;

    @Id
    @Column(name = "idpersonaldata")
    public int getIdpersonaldata() {
        return idpersonaldata;
    }

    public void setIdpersonaldata(int idpersonaldata) {
        this.idpersonaldata = idpersonaldata;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "born")
    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    @Basic
    @Column(name = "death")
    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaldataEntity that = (PersonaldataEntity) o;

        if (idpersonaldata != that.idpersonaldata) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (born != null ? !born.equals(that.born) : that.born != null) return false;
        if (death != null ? !death.equals(that.death) : that.death != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpersonaldata;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (born != null ? born.hashCode() : 0);
        result = 31 * result + (death != null ? death.hashCode() : 0);
        return result;
    }
}
