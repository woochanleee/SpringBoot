package com.woochanleee.hellospring.service;

import com.woochanleee.hellospring.domain.Member;
import com.woochanleee.hellospring.repository.MemberRepository;
import com.woochanleee.hellospring.service.MemberService;
import com.woochanleee.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @Commit
    void 회원가입() {
        // given
        Member member = new Member();

        member.setName("hello2");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(member.getId()).get();

        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();

        member1.setName("spring");

        Member member2  = new Member();

        member2.setName("spring");

        // when
        memberService.join(member1);

        String errorMessage = assertThrows(IllegalStateException.class, () -> memberService.join(member2)).getMessage();

        assertThat(errorMessage).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException error) {
//            assertThat(error.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        // then
    }

}