package MovieProject.demo.jwt;


import MovieProject.demo.dto.CustomUserDetails;
import MovieProject.demo.entity.MemberEntity;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    public JWTFilter(JWTUtil util){
        this.jwtUtil = util;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");

        //토큰 null 값 , 유효성 검사
        if (authorization == null || !authorization.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return ;
        }
        String token = authorization.split(" ")[1];

//        //토큰 만료시간 검사
//        if (jwtUtil.isExpired(token)) {
//            System.out.println("token expired");
//            filterChain.doFilter(request, response);
//            return ;
//        }
        try{
            jwtUtil.isExpired(token);
        }catch (Exception e ){
            System.out.println(e);
            response.setStatus(401);
            filterChain.doFilter(request, response);
            return ;
        }

        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        MemberEntity entity = MemberEntity.builder()
                .member_id(username)
                .member_pw("TMPPassWord")
                .member_role(MemberEntity.MemberRole.valueOf(role))
                .build();

        CustomUserDetails details = new CustomUserDetails(entity);
        Authentication authToken = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request,response);
    }

}
