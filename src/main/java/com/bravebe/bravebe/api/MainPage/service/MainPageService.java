package com.bravebe.bravebe.api.MainPage.service;

import com.bravebe.bravebe.aop.LoginCheck;
import com.bravebe.bravebe.api.MainPage.repository.MainPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainPageService {

    private final MainPageRepository mainPageRepository;

    @LoginCheck
    public Long selectNumberById(String loginId) {

        Long number = mainPageRepository.selectBearNumbers(loginId);

        return number;

    }

}
