package com.memorytree.forest.controller;

import com.memorytree.forest.dto.global.ResponseDto;
import com.memorytree.forest.dto.response.KakaoUserInfoResponseDto;
import com.memorytree.forest.service.KakaoOAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth2")
@RequiredArgsConstructor
public class KakaoOAuthController {

    private final KakaoOAuthService kakaoOAuthService;

    @GetMapping("/callback/kakao")
    public ResponseEntity<ResponseDto<KakaoUserInfoResponseDto>> handleKakaoCallback(@RequestParam String code) {
        KakaoUserInfoResponseDto userInfo = kakaoOAuthService.getKakaoUserInfo(code);
        return ResponseEntity.ok(ResponseDto.ok(userInfo));
    }
}
