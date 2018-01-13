package JPAEntity;

import javax.persistence.*;

@Entity
@Table(name = "collection", schema = "public", catalog = "khgmqurw")
public class CollectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcollection;
    private int idUser;
    private int idlocation;
    private int iddescription;

    @Id
    @Column(name = "idcollection")
    public int getIdcollection() {
        return idcollection;
    }

    public void setIdcollection(int idcollection) {
        this.idcollection = idcollection;
    }

    @Basic
    @Column(name = "idlocation")
    public int getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(int idlocation) {
        this.idlocation = idlocation;
    }

    @Basic
    @Column(name = "iddescription")
    public int getIddescription() {
        return iddescription;
    }

    public void setIddescription(int iddescription) {
        this.iddescription = iddescription;
    }

    @Basic
    @Column(name = "iduser")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
