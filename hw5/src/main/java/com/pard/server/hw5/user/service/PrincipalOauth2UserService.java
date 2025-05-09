package com.pard.server.hw5.user.service;

import com.pard.server.hw5.user.entity.Role;
import com.pard.server.hw5.user.entity.User;
import com.pard.server.hw5.user.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j // log.info 지원
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final UserRepo userRepo;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException{ // 예외가, 회원정보가 없으면 회원가입 시키는 거임

        log.info("구글에서 받아온 UserRequest: " + oAuth2UserRequest);
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        log.info("oauth에서 받아온 정보 : "+oAuth2User.getAttributes());

        String email = (String) oAuth2User.getAttributes().get("email");
        String name = (String) oAuth2User.getAttributes().get("name");
        String socialId = (String) oAuth2User.getAttributes().get("sub");

        userRepo.findByEmail(email) // 여기에서 받아온 거 DB에 넣음 (repo가 해줌)
                .orElseGet(()-> userRepo.save(
                        User.builder()
                                .email(email)
                                .name(name)
                                .socialId(socialId)
                                .role(Role.USER)
                                .build()
                ));

        return oAuth2User;
    }

}