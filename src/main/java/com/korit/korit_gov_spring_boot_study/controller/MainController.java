package com.korit.korit_gov_spring_boot_study.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
class UserDto {
    private Integer userId;
    private String username;
    private Integer age;
}

// SSR -> 서버쪽에서 렌더링 후 반환
@Controller
public class MainController {
    private List<UserDto> users = new ArrayList<>();

    // 동적 요소 x
    @GetMapping("/main")
    public String getMain() {
        return "main.html";
    }

    // SSR에 동적 추가하려면 Thymeleaf를 적용
    // 서버에서 html을 렌더링할때, java 데이터를 끼워 넣을 수 있게 해줌
    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("username", "<b>철수</b>");
        model.addAttribute("isAdult", false);
        model.addAttribute("age", 27);
        Map<String, String> userList = new HashMap<>();
        userList.put("일구", "15");
        userList.put("이구", "19");
        userList.put("삼구", "21");
        userList.put("사구", "25");
        userList.put("오구", "28");
        model.addAttribute("userList", userList);
        return "profile.html";
    }

    @GetMapping("/search")
    public String getSearch(@RequestParam String keyword, @RequestParam String keyword2, Model model) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("keyword2", keyword2);

        return "search.html";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@RequestParam String name, @RequestParam Integer age, Model model) {
        UserDto userDto = new UserDto(users.size() + 1, name, age);
        users.add(userDto);
        model.addAttribute("message", name + " 님, 가입을 환영합니다.");
        return "result-page";
    }

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("users", users);
        return "users";
    }
}
