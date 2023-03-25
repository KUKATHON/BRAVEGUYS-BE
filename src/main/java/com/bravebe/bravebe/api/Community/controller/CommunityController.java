package com.bravebe.bravebe.api.Community.controller;

import com.bravebe.bravebe.api.Community.service.CommunityService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class CommunityController {

    private final CommunityService communityService;


    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    // 전체 게시글 조회
    @GetMapping("/users/{userId}/list")
    public String postList(Model model) {

        model.addAttribute("list", communityService.postList());

        return "postList";
    }

    // 게시글 상세정보 조회
    @GetMapping("/users/{userId}/community/{postId}")
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


    // 게시글 작성
    @PostMapping("/users/{userId}/community/{postId}")
    public String postWrite() {
        return "postwrite";
    }
    // 게시글 수정
    // 게시글 삭제
}
