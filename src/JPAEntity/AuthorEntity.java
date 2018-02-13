package JPAEntity;

import javax.persistence.*;

@Entity
@Table(name = "author", schema = "public", catalog = "khgmqurw")
public class AuthorEntity {
    private int idauthor;
    private int idPersonalData;
    private int idContact;
    private int idDescription;

    @Id
    @Column(name = "idauthor")
    public int getIdauthor() {
        return idauthor;
    }

    public void setIdauthor(int idauthor) {
        this.idauthor = idauthor;
    }

    @Basic
    @Column(name = "idpersonaldata")
    public int getIdPersonalData() {
        return idPersonalData;
    }

    public void setIdPersonalData(int idPersonalData) {
        this.idPersonalData = idPersonalData;
    }
    @Basic
    @Column(name = "idcontact")
    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }
    @Basic
    @Column(name = "iddescription")
    public int getIdDescription() {
        return idDescription;
    }

    public void setIdDescription(int idDescription) {
        this.idDescription = idDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorEntity that = (AuthorEntity) o;

        if (idauthor != that.idauthor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idauthor;
    }
}
