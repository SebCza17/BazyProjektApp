package JPAEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "work", schema = "public", catalog = "khgmqurw")
public class WorkEntity {
    private int idwork;

    @Id
    @Column(name = "idwork")
    public int getIdwork() {
        return idwork;
    }

    public void setIdwork(int idwork) {
        this.idwork = idwork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkEntity that = (WorkEntity) o;

        if (idwork != that.idwork) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idwork;
    }
}
