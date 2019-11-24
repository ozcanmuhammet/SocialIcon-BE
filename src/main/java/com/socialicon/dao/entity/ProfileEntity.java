package com.socialicon.dao.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PROFILES")
@Data
public class ProfileEntity implements Serializable {

    public ProfileEntity(Long id, String fullname, String username) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
    }

    public ProfileEntity() {

    }

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="FULLNAME")
    private String fullname;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PICTURE")
    private String picture;
}
