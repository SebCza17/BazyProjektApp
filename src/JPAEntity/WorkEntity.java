package JPAEntity;

import javax.persistence.*;

@Entity
@Table(name = "work", schema = "public", catalog = "khgmqurw")
public class WorkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idwork;
    private int idcollection;
    private int idauthor;

    @Id
    @Column(name = "idwork")
    public int getIdwork() {
        return idwork;
    }

    public void setIdwork(int idwork) {
        this.idwork = idwork;
    }

    @Basic
    @Column(name = "idcollection")
    public int getIdcollection() {
        return idcollection;
    }

    public void setIdcollection(int idcollection) {
        this.idcollection = idcollection;
    }

    @Basic
    @Column(name = "idauthor")
    public int getIdauthor() {
        return idauthor;
    }

    public void setIdauthor(int idauthor) {
        this.idauthor = idauthor;
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
