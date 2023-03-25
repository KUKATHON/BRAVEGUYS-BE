package com.bravebe.bravebe.api.Community.controller;

import com.bravebe.bravebe.api.Community.service.CommunityService;
import com.bravebe.bravebe.api.dto.CommunityDTO;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/community")
@Tag(name = "Community Controller", description = "게시판 컨트롤러")
public class CommunityController {

    private final CommunityService communityService;

    /**
     * 전체 리스트 조회
     * GET
     * @return ResponseEntity - list<Post>
     */
    @Operation(summary = "게시판 조회 API", description = "전체 게시판 리스트를 조회한다.")
    @GetMapping(value = "list")
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

    /**
     * 게시글 상세정보 조회
     * GET
     * @return ResponseEntity - Post
     */
    @Operation(summary = "상세정보 조회 API", description = "게시판 상세정보를 조회한다.")
    @GetMapping("detail")
    public ResponseEntity<BaseResponseBody<Optional<Post>>> postView(
            @RequestParam String postId
    ) {

        Optional<Post> result = communityService.postView(postId);

        return new ResponseEntity<BaseResponseBody<Optional<Post>>>(
                new BaseResponseBody<Optional<Post>>(
                        HttpStatus.OK.value(),
                        "성공",
                        result
                ),
                HttpStatus.OK
        );

    }

    /**
     * 내 인증(게시글)만 조회
     * GET
     * @return ResponseEntity - list<Post>
     */
    @Operation(summary = "내 게시글 조회 API", description = "내 게시글을 조회한다.")
    @GetMapping("own")
    public ResponseEntity<BaseResponseBody<List<Post>>> ownView(
            @RequestParam String userId) {

        List<Post> list = communityService.ownList(userId);

        return new ResponseEntity<BaseResponseBody<List<Post>>>(
                new BaseResponseBody<List<Post>>(
                        HttpStatus.OK.value(),
                        "성공",
                        list
                ),
                HttpStatus.OK
        );
    }

}
