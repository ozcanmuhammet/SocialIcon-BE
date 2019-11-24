package com.socialicon.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="OFFERS")
@Data
public class OfferEntity implements Serializable {

    @Id
    @Column(name="OFFER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @Column(name="USER_ID")
    private Long userId;

    @Column(name="URL")
    private String url;

    @Column(name = "TITLE")
    private String title;

    @Column(name="PLATFORM_ID")
    private Integer platformId;

    @Column(name="COIN")
    private Integer coin;

    @Column(name="DURATION")
    private Integer duration;

    @Column(name="COUNTER")
    private Integer counter;

    @Column(name="CREATE_DATE")
    private Date createDate;

    @Column(name="LIKE_COUNT")
    private Integer likeCount;

    @Column(name="SHARE_COUNT")
    private Integer shareCount;

    @Column(name="AGREEMENT_COUNT")
    private Integer agreementCount;

    @Column(name="VIEWING_COUNT")
    private Integer viewingCount;
}
