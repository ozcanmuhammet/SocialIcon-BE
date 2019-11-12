package com.socialicon.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ACCOUNT")
@Data
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="PHONE")
    private String phone;
}
