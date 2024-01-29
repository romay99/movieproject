package MovieProject.demo.controller;

import MovieProject.demo.dto.MemberSignUpDto;
import MovieProject.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginPage() {
        return "loginpage";
    }

    @PostMapping("/login")
    public void memberLogin() { // JWT 토큰 방식으로 개발해야함

    }

    @GetMapping("/signup")
    public String signUpPage() {
        return "signUpPage";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUpMember(@RequestBody MemberSignUpDto dto) {
        System.out.println(dto);
        memberService.signUpMember(dto);
        return ResponseEntity.ok().body("환영합니다" + dto.member_name + "님!");
    }

    @PostMapping("/idCheck")
    public ResponseEntity<String> isIdPresent(String memberId){
        if (memberService.isIdPresent(memberId)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
