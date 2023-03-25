package com.bravebe.bravebe.api.Market.repository;

import com.bravebe.bravebe.domain.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarketRepository extends JpaRepository<Market, Integer> {

    @Query("select m from Market m where m.category = :category")
    Optional<Market> findbyCategory(String category);

}
