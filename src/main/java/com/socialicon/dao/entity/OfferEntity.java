package com.socialicon.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="OFFER")
@Data
public class OfferEntity implements Serializable {

    @Id
    @Column(name="OFFER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @Column(name = "TITLE")
    private String title;
}
