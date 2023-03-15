package com.example.finalproject.infrastructure.adapters.jpa;

import com.example.finalproject.domain.usecase.entity.SettlementDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISettlementRepositoryAdapter extends JpaRepository<SettlementDBO, String> {
}
