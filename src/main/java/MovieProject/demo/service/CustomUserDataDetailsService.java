package MovieProject.demo.service;

import MovieProject.demo.dto.CustomUserDetails;
import MovieProject.demo.entity.MemberEntity;
import MovieProject.demo.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
// 스프링 시큐리티 로그인을 위한 서비스 객체
public class CustomUserDataDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public CustomUserDataDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        if (memberRepository.findByUsername(userId).isPresent()) {
            MemberEntity userData = memberRepository.findByUsername(userId).get();
            return new CustomUserDetails(userData);
        }
        return null;
    }
}
