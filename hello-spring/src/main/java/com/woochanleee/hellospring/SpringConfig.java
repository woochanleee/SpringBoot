package com.woochanleee.hellospring;

import com.woochanleee.hellospring.repository.MemberRepository;
import com.woochanleee.hellospring.repository.MemoryMemberRepository;
import com.woochanleee.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
         return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
