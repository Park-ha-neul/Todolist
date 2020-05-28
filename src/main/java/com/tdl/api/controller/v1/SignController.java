package com.tdl.api.controller.v1;
import com.tdl.api.service.ResponseService;
import com.tdl.api.service.social.KakaoService;

import com.tdl.api.config.security.JwtTokenProvider;

import com.tdl.api.repo.UserJpaRepo;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserJpaRepo userJpaRepo;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;
    private final KakaoService kakaoService;

}