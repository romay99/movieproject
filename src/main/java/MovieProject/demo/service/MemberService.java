package MovieProject.demo.service;

import MovieProject.demo.dto.MemberSignUpDto;
import MovieProject.demo.entity.MemberEntity;
import MovieProject.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUpMember(MemberSignUpDto dto){
        MemberEntity newMember = MemberEntity.builder()
                .member_id(dto.member_id)
                .member_pw(dto.member_pw)
                .member_email(dto.member_email)
                .member_name(dto.member_name)
                .member_role(MemberEntity.MemberRole.MEMBER_USER)
                .build();

        memberRepository.save(newMember);
    }
}
