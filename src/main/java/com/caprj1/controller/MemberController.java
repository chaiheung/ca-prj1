package com.caprj1.controller;

import com.caprj1.domain.Member;
import com.caprj1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {
    private final MemberService service;

    @GetMapping("signup")
    public String signupForm() {
        return "member/signup";
    }

    @PostMapping("signup")
    public String signup(Member member) {
        service.signup(member);
        return "redirect:/";
    }

    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute(service.list());
        return "member/list";
    }
}
