package com.example.finalproject.domain.gateway;

import com.example.finalproject.domain.model.settlement.Settlement;

import java.util.List;

public interface ISettlementRepository {

    Settlement saveSettlement(Settlement settlement);

    List<Settlement>getSettlements();

    Boolean deleteSettlement(String id);

}
