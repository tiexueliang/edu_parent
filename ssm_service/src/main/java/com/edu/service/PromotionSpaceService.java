package com.edu.service;

import com.edu.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {

    public List<PromotionSpace> findAllPromotionSpace();

    void savePromotionSpace(PromotionSpace promotionSpace);

    PromotionSpace findPromotionSpaceById(int id);

    void updatePromotionSpace(PromotionSpace promotionSpace);
}
