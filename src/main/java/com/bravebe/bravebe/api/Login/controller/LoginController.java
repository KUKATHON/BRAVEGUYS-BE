package com.bravebe.bravebe.api.Login.controller;

import com.bravebe.bravebe.api.Login.service.LoginService;
import com.bravebe.bravebe.api.dto.LoginDTO;
import com.bravebe.bravebe.common.SessionUtil;
import com.bravebe.bravebe.common.response.BaseResponseBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/login")
@Tag(name = "Login Controller", description = "로그인 컨트롤러")
public class LoginController {

    private final LoginService loginService;

    /**
     * 로그인 api
     */
    @Operation(summary = "[테스트용] 회원 로그인 API", description = "회원 로그인 처리 후 방문자 기록을 저장한다.")
    @PostMapping("/login")
    public ResponseEntity<BaseResponseBody<String>> login(@RequestBody LoginDTO loginDTO,
                                                          HttpServletRequest request) {

        String loginId = loginService.login(loginDTO);
        // 회원이 아닌 경우
        if (loginId.equals("NO_DATA")) {
            return new ResponseEntity<BaseResponseBody<String>>(
                    new BaseResponseBody<String>(
                            HttpStatus.NOT_FOUND.value(),
                            "회원 정보가 존재하지 않습니다.",
                            "NO_DATA"
                    ),
                    HttpStatus.NOT_FOUND
            );
        }
        // 비밀번호가 틀린 경우
        else if (loginId.equals("WRONG_PWD")) {
            return new ResponseEntity<BaseResponseBody<String>>(
                    new BaseResponseBody<String>(
                            HttpStatus.NOT_FOUND.value(),
                            "비밀번호가 틀렸습니다.",
                            "WRONG_PWD"
                    ),
                    HttpStatus.NOT_FOUND
            );
        }
        // 로그인 성공한 경우
        else {
            // 세션이 있으면 존재하는 세션 반환
            // 세션이 없으면 신규 세션을 생성해서 반환
            HttpSession session = request.getSession();
            // 세션에 로그인 아이디 정보 저장
            SessionUtil.setLoginId(session, loginId);
            return new ResponseEntity<BaseResponseBody<String>>(
                    new BaseResponseBody<String>(
                            HttpStatus.OK.value(),
                            "성공",
                            loginId
                    ),
                    HttpStatus.OK
            );
        }

    }

}
