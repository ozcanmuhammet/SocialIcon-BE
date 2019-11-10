package com.socialicon.web.controller.offer;

import com.socialicon.dao.entity.OfferEntity;
import com.socialicon.service.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    public List<OfferEntity> getOffersList() {
        return offerService.getOffersList();
    }
}
