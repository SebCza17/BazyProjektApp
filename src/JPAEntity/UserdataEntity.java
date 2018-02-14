package JPAEntity;

import javax.persistence.*;

@Entity
@Table(name = "userdata", schema = "public", catalog = "khgmqurw")
public class UserdataEntity {
    private int id;
    private int idPersonalData;
    private int idContact;
    private int idDescription;


    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
