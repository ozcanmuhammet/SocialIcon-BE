package com.socialicon.service.offer;

import com.socialicon.common.enums.ErrorCodes;
import com.socialicon.common.exceptions.OfferNotFoundException;
import com.socialicon.common.exceptions.UserNotFoundException;
import com.socialicon.dao.entity.OfferEntity;
import com.socialicon.dao.entity.UserEntity;
import com.socialicon.dao.repository.OfferRepository;
import com.socialicon.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<OfferEntity> getOfferList(Long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);

        if(user==null){
            throw new UserNotFoundException(ErrorCodes.USER_NOT_FOUND.getErrorMessage() + userId);
        }

        List<OfferEntity> offerList = offerRepository.findByUserId(userId);
        return offerList;
    }

    public Optional<OfferEntity> getOffer(Long offerId){
        Optional<OfferEntity> offer = offerRepository.findById(offerId);
        if(offer==null){
            throw new OfferNotFoundException(ErrorCodes.OFFER_NOT_FOUND .getErrorMessage() + offerId);
        }
        return offer;
    }


}
