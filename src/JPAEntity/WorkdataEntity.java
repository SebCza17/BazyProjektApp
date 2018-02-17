package JPAEntity;

import javax.persistence.*;

@Entity
@Table(name = "workdata", schema = "public", catalog = "khgmqurw")
public class WorkdataEntity {
    private String year;
    private String epoch;
    private int idWork;
    private int idDescription;
    private int idImage;

    @Id
    @Column(name = "idwork")
    public int getIdWork() {
        return idWork;
    }

    public void setIdWork(int idWork) {
        this.idWork = idWork;
    }

    @Basic
    @Column(name = "iddescription")
    public int getIdDescription() {
        return idDescription;
    }

    public void setIdDescription(int idDescription) {
        this.idDescription = idDescription;
    }

    @Basic
    @Column(name = "idimage")
    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    @Basic
    @Column(name = "year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "epoch")
    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkdataEntity that = (WorkdataEntity) o;

        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (epoch != null ? !epoch.equals(that.epoch) : that.epoch != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 + (year != null ? year.hashCode() : 0);
        result = 31 * result + (epoch != null ? epoch.hashCode() : 0);
        return result;
    }
}
