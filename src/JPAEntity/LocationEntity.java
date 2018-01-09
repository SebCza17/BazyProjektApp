package JPAEntity;

import javax.persistence.*;

@Entity
@Table(name = "location", schema = "public", catalog = "khgmqurw")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idlocation;

    @Id
    @Column(name = "idlocation")
    public int getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(int idlocation) {
        this.idlocation = idlocation;
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
