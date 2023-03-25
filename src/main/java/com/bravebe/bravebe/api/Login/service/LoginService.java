package com.bravebe.bravebe.api.Login.service;

import com.bravebe.bravebe.api.Login.repository.LoginRepository;
import com.bravebe.bravebe.api.dto.LoginDTO;
import com.bravebe.bravebe.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    public String login(LoginDTO loginDTO) {
        /**
         * 1. 회원이 입력한 이메일로 DB에서 조회를 함
         * 2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<Member> optionalMember = loginRepository.findById(loginDTO.getId());
        // 해당 이메일을 가진 회원 정보가 있는 경우
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            // 비밀번호 일치
            if (member.getPwd().equals(loginDTO.getPwd())) {
                // entity -> dto 변환 후 리턴
                return member.getUserid();
            }else { // 비밀번호 불일치
                return "WRONG_PWD";
            }
        } else { // 회원이 아닌 경우
            return "NO_DATA";
        }
    }

}
