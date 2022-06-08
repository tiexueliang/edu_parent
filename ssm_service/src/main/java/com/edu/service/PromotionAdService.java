package com.edu.service;

import com.github.pagehelper.PageInfo;
import com.edu.domain.PromotionAd;
import com.edu.domain.PromotionAdVo;

public interface PromotionAdService {


    /*
    分页获取所有的广告列表
*/
    public PageInfo findAllAdByPage(PromotionAdVo adVo);


    void savePromotionAd(PromotionAd promotionAd);

    void updatePromotionAd(PromotionAd promotionAd);

    void updatePromotionAdStatus(int id, int status);

    PromotionAd findPromotionAdById(int id);
}
