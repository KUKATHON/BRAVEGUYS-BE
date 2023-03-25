package com.bravebe.bravebe.api.MyPage.controller;

import com.bravebe.bravebe.api.MyPage.service.MyPageService;
import com.bravebe.bravebe.common.response.BaseResponseBody;
import com.bravebe.bravebe.domain.Member;
import com.bravebe.bravebe.domain.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Tag(name = "MyPage Controller", description = "마이페이지 컨트롤러")
public class MyPageController {
    private final MyPageService myPageService;

    @GetMapping(value = "users/myInfo")
    @Operation(summary = "[테스트용] 마이페이지 API", description = "내 정보를 조회한다.")
    public ResponseEntity<BaseResponseBody<Optional<Member>>> myInfo(@RequestParam String userid) {
        Optional<Member> member = myPageService.memberInfo(userid);

        return new ResponseEntity<BaseResponseBody<Optional<Member>>>(
                new BaseResponseBody<Optional<Member>>(
                        HttpStatus.OK.value(),
                        "성공",
                        member
                ),
                HttpStatus.OK
        );

    }


}
