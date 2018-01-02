package JPAEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author", schema = "public", catalog = "khgmqurw")
public class AuthorEntity {
    private int idauthor;

    @Id
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

        AuthorEntity that = (AuthorEntity) o;

        if (idauthor != that.idauthor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idauthor;
    }
}
