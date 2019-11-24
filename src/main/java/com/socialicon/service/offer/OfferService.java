package com.socialicon.service.offer;

import com.socialicon.dao.entity.OfferEntity;

import java.util.List;
import java.util.Optional;

public interface OfferService {

    List<OfferEntity> getOfferList(Long userId);

    Optional<OfferEntity> getOffer(Long offerId);
}
