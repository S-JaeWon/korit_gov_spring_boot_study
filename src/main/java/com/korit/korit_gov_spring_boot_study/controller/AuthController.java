package com.korit.korit_gov_spring_boot_study.controller;

import com.korit.korit_gov_spring_boot_study.dto.Request.SigninReqDto;
import com.korit.korit_gov_spring_boot_study.dto.Request.SignupReqDto;
import com.korit.korit_gov_spring_boot_study.dto.Respone.SigninRespDto;
import com.korit.korit_gov_spring_boot_study.dto.Respone.SignupRespDto;
import com.korit.korit_gov_spring_boot_study.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private UserService userService;

    public AuthController() {
        userService = UserService.getInstance();
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupRespDto> signup(@RequestBody SignupReqDto signupReqDto) {
        return ResponseEntity.ok(userService.signup(signupReqDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<SigninRespDto> signin(@RequestBody SigninReqDto signinReqDto) {
        return ResponseEntity.ok(userService.signin(signinReqDto));
    }


    /*
    * 파라미터가 없거나, 타입 및 이름이 안 맞으면 에러400
    *
    * RequestParam 은 url에 값이 저장되어 보이기 때문에 정보 보안에 취약
    * */

///*    @GetMapping("/get")
//    public String getUser(@RequestParam String userId) {
//        System.out.println("쿼리 파라미터로 들어온 값: " + userId);
//        return "쿼리 파라미터로 들어온 값: " + userId;
//    }
//
//    @GetMapping("/get/name")
//    public String getUsername
//            (@RequestParam(value = "name", defaultValue = "철수") String username, // value를 통해 파람키 이름 다르게, defaultValue로 기본값 설정 가능
//             @RequestParam(required = false) Integer age) { // 원시 자료형은 null 값 포함 안됨 ex) int 사용 불가
//        return username + age;
//    }
//
//    @PostMapping("/signup1")
//    public String signup(@RequestBody SignupReqDto signupReqDto) {
//        System.out.println(signupReqDto);
//        return signupReqDto.getUsername() + " 님 회원 가입 완료";
//    }
//    *//*
//    * Post 메서드는 RequestBody
//    * - 바디에 있는 JSON 데이터를 DTO로 변환해서 매핑 후 주입
//    * - 단 키와 객체의 멤버변수의 이름과 일치해야 함
//    * Get 메서드는 RequestParam
//    * *//*
//
//    @PostMapping("/signin")
//    public String signin(@RequestBody SigninReqDto signinReqDto) {
//        return "로그인 성공: " + signinReqDto.getUsername();
//    }
//
//    *//*
//    * ResponseEntity
//    * HTTp 응답 전체를 커스터마이징 해서 응답 할 수 있는 스프링 클래스
//    * 상태코드
//    * 200
//    * 400
//    * 401 인증 실패
//    * 403 접근 권한
//    * 404
//    * 500
//    *
//    *  *//*
//    @PostMapping("/signup1")
//    public ResponseEntity<SignupRespDto> signup(@RequestBody SignupReqDto signupReqDto) {
//        if (signupReqDto.getUsername() == null || signupReqDto.getUsername().trim().isBlank()) {
//            SignupRespDto signupRespDto = new SignupRespDto("failed", "username을 입력하세요");
//            return ResponseEntity.badRequest().body(signupRespDto);
//        } else if (signupReqDto.getPassword() == null || signupReqDto.getPassword().trim().isEmpty()) {
//            SignupRespDto signupRespDto = new SignupRespDto("failed", "비밀번호를 입력하세요");
//            return ResponseEntity.badRequest().body(signupRespDto);
//        }
//        SignupRespDto signupRespDto = new SignupRespDto("success", "회원가입 성공");
//        return ResponseEntity.ok(signupRespDto);
//    }*/



}
