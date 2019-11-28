package com.socialicon.web.controller;

import com.socialicon.dao.entity.OfferEntity;
import com.socialicon.service.OfferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping("/offers")
    public ResponseEntity<Object> createOffer(@RequestBody OfferEntity offer) {
        offerService.createOffer(offer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{offerId}").buildAndExpand(offer.getOfferId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{userId}/offers")
    public List<OfferEntity> getOfferList(@PathVariable Long userId) {
        return offerService.getOfferList(userId);
    }

    @GetMapping("/offers/{offerId}")
    public Optional<OfferEntity> getOffer(@PathVariable Long offerId){
        return offerService.getOffer(offerId);
    }
}
