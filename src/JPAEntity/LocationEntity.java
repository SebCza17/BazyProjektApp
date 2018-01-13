package JPAEntity;

import javax.persistence.*;

@Entity
@Table(name = "location", schema = "public", catalog = "khgmqurw")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idlocation;
    private int idcontact;
    private int iddescription;

    @Id
    @Column(name = "idlocation")
    public int getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(int idlocation) {
        this.idlocation = idlocation;
    }

    @Basic
    @Column(name = "idcontact")
    public int getIdcontact() {
        return idcontact;
    }

    public void setIdcontact(int idcontact) {
        this.idcontact = idcontact;
    }

    @Basic
    @Column(name = "iddescription")
    public int getIddescription() {
        return iddescription;
    }

    public void setIddescription(int iddescription) {
        this.iddescription = iddescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationEntity that = (LocationEntity) o;

        if (idlocation != that.idlocation) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idlocation;
    }
}
