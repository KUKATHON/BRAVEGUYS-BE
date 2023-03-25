package com.bravebe.bravebe.api.MyPage.controller;

import com.bravebe.bravebe.api.MyPage.service.MyPageService;
import com.bravebe.bravebe.common.response.BaseResponseBody;
import com.bravebe.bravebe.domain.Member;
import com.bravebe.bravebe.domain.Post;
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
public class MyPageController {
    private final MyPageService myPageService;

    @GetMapping(value = "users/{userId}/myInfo")
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
