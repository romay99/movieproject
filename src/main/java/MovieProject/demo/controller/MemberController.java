package MovieProject.demo.controller;

import MovieProject.demo.dto.MemberSignUpDto;
import MovieProject.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginPage() {
        return "loginpage";
    }

    @GetMapping("/signup")
    public String signUpPage() {
        return "signUpPage";
    }

    @PostMapping("/signup")
    public String signUpMember(MemberSignUpDto dto){
        memberService.signUpMember(dto);
        return "redirect:/";
    }
}
