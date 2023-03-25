package com.bravebe.bravebe.api.Reply.service;

import com.bravebe.bravebe.api.Reply.repository.ReplyRepository;
import com.bravebe.bravebe.domain.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;


    //댓글 작성 or 수정
    public void write(Reply reply) throws IOException {

        replyRepository.save(reply);
    }

    //댓글 조회
    //댓글 삭제
}
