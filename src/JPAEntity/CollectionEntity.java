package JPAEntity;

import javax.persistence.*;

@Entity
@Table(name = "collection", schema = "public", catalog = "khgmqurw")
public class CollectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcollection;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="iduser")
    private UserEntity userEntity;

    @Id
    @Column(name = "idcollection")
    public int getIdcollection() {
        return idcollection;
    }

    public void setIdcollection(int idcollection) {
        this.idcollection = idcollection;
    }


    public UserEntity getUserEntity(){
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity){
        this.userEntity = userEntity;
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
