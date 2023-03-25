package com.bravebe.bravebe.api.MainPage.controller;

import com.bravebe.bravebe.aop.LoginCheck;
import com.bravebe.bravebe.api.MainPage.service.MainPageService;
import com.bravebe.bravebe.common.SessionUtil;
import com.bravebe.bravebe.common.response.BaseResponseBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/uesrs")
@Tag(name = "MainPage Controller", description = "메인페이지 컨트롤러")
public class MainPageController {

    private final MainPageService mainPageService;

    @Operation(summary = "메인페이지 - 북극곰 단계 보내주기 API", description = "북극곰 개수 보내주기")
    @GetMapping("/list")
    @LoginCheck
    public ResponseEntity<BaseResponseBody<Long>> sendMainPageNumber (HttpSession session) {

        String loginId = SessionUtil.getLoginId(session);

        Long number = mainPageService.selectNumberById(loginId);

        return new ResponseEntity<BaseResponseBody<Long>> (
                new BaseResponseBody<Long>(
                        HttpStatus.OK.value(),
                        "성공",
                        number
                ),
                HttpStatus.OK
        );

    }

}
