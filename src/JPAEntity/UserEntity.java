package JPAEntity;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "public", catalog = "khgmqurw")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;

    private String pass;
    private String email;
    private String permissions;

    @Id
    @Column(name = "iduser")
    public int getIduser() {
        return iduser;
    }

    private void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "pass")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "permissions")
    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (iduser != that.iduser) return false;
        if (pass != null ? !pass.equals(that.pass) : that.pass != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (permissions != null ? !permissions.equals(that.permissions) : that.permissions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iduser;
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (permissions != null ? permissions.hashCode() : 0);
        return result;
    }
}
