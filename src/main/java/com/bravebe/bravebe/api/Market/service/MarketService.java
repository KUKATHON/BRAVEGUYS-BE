package com.bravebe.bravebe.api.Market.service;

import com.bravebe.bravebe.api.Market.repository.MarketRepository;
import com.bravebe.bravebe.domain.Market;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarketService {
    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    //전체 마켓 조회
    public List<Market> marketList() {

        return marketRepository.findAll();
    }

    //카테고리별 마켓 조회
    public Optional<Market> categoryMarketList(String category) {
        return marketRepository.findbyCategory(category);
    }
}
