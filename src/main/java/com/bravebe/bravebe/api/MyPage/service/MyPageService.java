package com.bravebe.bravebe.api.MyPage.service;

import com.bravebe.bravebe.api.MyPage.repository.MyPageRepository;
import com.bravebe.bravebe.domain.Member;
import com.bravebe.bravebe.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final MyPageRepository myPageRepository;

    // 내 정보 조회
    public Optional<Member> memberInfo(String id) {

        return myPageRepository.findByUserId(id);
    }


}
