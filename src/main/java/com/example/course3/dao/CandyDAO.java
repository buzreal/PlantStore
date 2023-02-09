package com.example.course3.dao;


import com.example.course3.data.CandyData;

import java.util.List;

public interface CandyDAO<T> {
    List<CandyData> list();
    void addToDelivery(Long candyId, Long deliveryId);
    List<CandyData> findByDelivery(Long deliveryId);

}

