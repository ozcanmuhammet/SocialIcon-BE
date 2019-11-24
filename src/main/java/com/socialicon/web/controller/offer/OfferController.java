package com.socialicon.web.controller.offer;

import com.socialicon.dao.entity.OfferEntity;
import com.socialicon.service.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/users/{userId}/offers")
    public List<OfferEntity> getOfferList(@PathVariable Long userId) {
        return offerService.getOfferList(userId);
    }

    @GetMapping("/offers/{offerId}")
    public Optional<OfferEntity> getOffer(@PathVariable Long offerId){
        return offerService.getOffer(offerId);
    }
}
