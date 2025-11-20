package com.korit.korit_gov_spring_boot_study.service;


import com.korit.korit_gov_spring_boot_study.dto.Request.SigninReqDto;
import com.korit.korit_gov_spring_boot_study.dto.Request.SignupReqDto;
import com.korit.korit_gov_spring_boot_study.dto.Respone.SigninRespDto;
import com.korit.korit_gov_spring_boot_study.dto.Respone.SignupRespDto;
import com.korit.korit_gov_spring_boot_study.entity.User;
import com.korit.korit_gov_spring_boot_study.repository.UserRepository;

public class UserService {
    private static UserService instance;
    private UserRepository userRepository;

    private UserService() {
        userRepository = UserRepository.getInstance();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public SignupRespDto signup(SignupReqDto signupReqDto) {
        if (userRepository.searchUsername(signupReqDto.getUsername()) != null) {
            return new SignupRespDto("failed", "이미 사용중인 username입니다.");
        }
        userRepository.addUser(signupReqDto.toEntity());
        return new SignupRespDto("success", "회원가입 완료");
    }

    public SigninRespDto signin(SigninReqDto signinReqDto) {
        User searchUser = userRepository.searchUsername(signinReqDto.getUsername());
        if (searchUser == null) {
            return new SigninRespDto("failed", "일치하는 username이 없습니다.");
        }

        if (!searchUser.getPassword().equals(signinReqDto.getPassword())) {
            return new SigninRespDto("failed", "일치하는 password가 없습니다.");
        }
        return new SigninRespDto("success", "로그인 성공");
    }
}
