package com.bravebe.bravebe.api.Market.controller;

import com.bravebe.bravebe.api.Market.service.MarketService;
import com.bravebe.bravebe.common.response.BaseResponseBody;
import com.bravebe.bravebe.domain.Market;
import com.bravebe.bravebe.domain.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/market")
@Tag(name = "Market Controller", description = "마켓 컨트롤러")
public class MarketController {
    private final MarketService marketService;

    @Operation(summary = "마켓 조회 API", description = "마켓 리스트를 조회한다.")
    @GetMapping("/list")
    public ResponseEntity<BaseResponseBody<List<Market>>> marketList() {

        List<Market> result = marketService.marketList();

        return new ResponseEntity<BaseResponseBody<List<Market>>>(
                new BaseResponseBody<List<Market>>(
                        HttpStatus.OK.value(),
                        "성공",
                        result
                ),
                HttpStatus.OK
        );
    }

    @Operation(summary = "카테고리별 마켓 조회 API", description = "카테고리별 마켓 리스트를 조회한다.")
    @GetMapping("/categoryList")
    public ResponseEntity<BaseResponseBody<Optional<Market>>> categoryMarketList(
            @RequestParam String category
    ) {

        Optional<Market> result =  marketService.categoryMarketList(category);

        return new ResponseEntity<BaseResponseBody<Optional<Market>>>(
                new BaseResponseBody<Optional<Market>>(
                        HttpStatus.OK.value(),
                        "성공",
                        result
                ),
                HttpStatus.OK
        );

    }

}
