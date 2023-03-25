package com.bravebe.bravebe.api.Community.controller;

import com.bravebe.bravebe.api.Community.service.CommunityService;
import com.bravebe.bravebe.api.dto.CommunityDTO;
import com.bravebe.bravebe.common.response.BaseResponseBody;
import com.bravebe.bravebe.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    /**
     * 전체 리스트 조회
     * GET
     * @return CommunityDTO - list
     */
    @GetMapping(value = "users/{userId}/list")
    public ResponseEntity<BaseResponseBody<List<Post>>> postList() {

        List<Post> list = communityService.postList();

        return new ResponseEntity<BaseResponseBody<List<Post>>>(
                new BaseResponseBody<List<Post>>(
                        HttpStatus.OK.value(),
                        "성공",
                        list
                ),
                HttpStatus.OK
        );

    }

    // 게시글 상세정보 조회
    @GetMapping("/users/{userId}/community")
    public String postView(Model model, Integer id) {
        model.addAttribute("post", communityService.postView(id).get()); //이건 postId
        return "postview";
    }

    // 내 인증(게시글)만 조회
    @GetMapping("/users/{userId}/own")
    public String ownView(Model model, Integer id) {
        model.addAttribute("post", communityService.postView(id).get()); //이건 userId
        return "ownview";
    }

}
