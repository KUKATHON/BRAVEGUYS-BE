package com.bravebe.bravebe.api.Community.service;

import com.bravebe.bravebe.api.Community.repository.CommunityRepository;
import com.bravebe.bravebe.api.dto.CommunityDTO;
import com.bravebe.bravebe.domain.Post;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CommunityService {

    private final CommunityRepository communityRepository;

    public CommunityService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    //전체 글 조회
    public List<CommunityDTO> postList() {

        return communityRepository.selectInPost();
    }

    //특정 글 상세정보 조회 -> postId
    public Optional<Post> postView(Integer id) {

        return communityRepository.findById(id);
    }

    //내 인증(게시글)만 조회 -> userId
    public Optional<Post> ownList(Integer id) {

        return communityRepository.findById(id);
    }

    //글 삭제
    public void postDelete(Integer id) {

        communityRepository.deleteById(id);
    }

    // select nickname
    public String selectNickname(Integer id) {

        communityRepository.findById(id);

    }

}
