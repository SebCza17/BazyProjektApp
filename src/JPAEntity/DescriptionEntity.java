package JPAEntity;

import javax.persistence.*;

@Entity
@Table(name = "description", schema = "public", catalog = "khgmqurw")
public class DescriptionEntity {
    private int iddescription;
    private String description;

    @Id
    @Column(name = "iddescription")
    public int getIddescription() {
        return iddescription;
    }

    public void setIddescription(int iddescription) {
        this.iddescription = iddescription;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DescriptionEntity that = (DescriptionEntity) o;

        if (iddescription != that.iddescription) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iddescription;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
