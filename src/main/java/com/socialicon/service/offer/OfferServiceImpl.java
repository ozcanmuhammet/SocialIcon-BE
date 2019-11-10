package com.socialicon.service.offer;

import com.socialicon.dao.entity.OfferEntity;
import com.socialicon.dao.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository repository;

    @Override
    public List<OfferEntity> getOffersList() {
        List<OfferEntity> offerList = repository.findAll();
        System.out.println("adsadasd");
       System.out.println(offerList);
        return offerList;
    }
}
