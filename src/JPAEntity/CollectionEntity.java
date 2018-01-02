package JPAEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collection", schema = "public", catalog = "khgmqurw")
public class CollectionEntity {
    private int idcollection;

    @Id
    @Column(name = "idcollection")
    public int getIdcollection() {
        return idcollection;
    }

    public void setIdcollection(int idcollection) {
        this.idcollection = idcollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionEntity that = (CollectionEntity) o;

        if (idcollection != that.idcollection) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idcollection;
    }
}
