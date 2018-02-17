package JPAEntity;

import javax.persistence.*;

@Entity
@Table(name = "images", schema = "public", catalog = "khgmqurw")
public class ImagesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idimage;
    //@Lob
    @Column(name = "picture")
    private byte[] picturepic;

    @Basic
    @Column(name = "idimage")
    public int getIdimage() {
        return idimage;
    }

    public void setIdimage(int idimage) {
        this.idimage = idimage;
    }

    @Basic
    @Column(name = "picture")
    public byte[] getPicture() {
        return picturepic;
    }

    public void setPicture(byte[] profilePic) {
        this.picturepic = profilePic;
    }
}
