package com.cenyol.example.model;

/**
 * Created by fours on 20.05.2016.
 */
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comments2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String post;
    private int Rating;
    private Long commentId; //не вторичный ключ, потому что необязателен, используется только для
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn
    private Files file;


    public Files getFile() {
        return file;
    }

    public void setFile(Files file) {
        this.file = file;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//комментариев, которые являются ответом на комментарии
    //как их огрнаничивать и выводить деревом???





    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments2)) {
            return false;
        }
        Comments2 other = (Comments2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.comments[ id=" + id + " ]";
    }

}