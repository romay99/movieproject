package MovieProject.demo.controller;

import MovieProject.demo.dto.LoginDto;
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

    @GetMapping("/signup")
    public String signUpPage() {
        return "signUpPage";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUpMember(@RequestBody MemberSignUpDto dto) {
        System.out.println(dto);
        memberService.signUpMember(dto);
        return ResponseEntity.ok().body("환영합니다 " + dto.member_name + " 님!");
    }

    @PostMapping("/idCheck")
    public ResponseEntity<String> idCheck(@RequestBody MemberSignUpDto dto){
        if(memberService.isIdPresent(dto.getMember_id())){
            return ResponseEntity.badRequest().body("이미 존재하는 ID 입니다.");
        }
        return ResponseEntity.ok().body("사용가능한 ID 입니다.");
    }

}
