package com.bravebe.bravebe.api.Market.controller;

import com.bravebe.bravebe.api.Market.service.MarketService;
import com.bravebe.bravebe.common.response.BaseResponseBody;
import com.bravebe.bravebe.domain.Market;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/market")
@Tag(name = "Market Controller", description = "마켓 컨트롤러")
public class MarketController {
    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

//    @Operation(summary = "[테스트용] 마켓 조회 API", description = "마켓 리스트를 조회한다.")
//    @GetMapping("/list")
//    public ResponseEntity<BaseResponseBody<List<Market>>>

    @Operation(summary = "[테스트용] 마켓 조회 API", description = "마켓 리스트를 조회한다.")
    @GetMapping("/list")
    public Model marketList(Model model) {

        model.addAttribute("list", marketService.marketList());

        return model;
    }

    @Operation(summary = "[테스트용] 카테고리별 마켓 조회 API", description = "카테고리별 마켓 리스트를 조회한다.")
    @GetMapping("/{category}/list")
    public String categoryMarketList(Model model) {

        model.addAttribute("categoryList", marketService.categoryMarketList((String) model.getAttribute("category")));

        return "categoryMarketList";
    }

}
