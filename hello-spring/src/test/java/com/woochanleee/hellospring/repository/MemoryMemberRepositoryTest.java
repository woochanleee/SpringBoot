package com.woochanleee.hellospring.repository;

import com.woochanleee.hellospring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clear();
    }

    @Test
    public void save() {
        Member member = new Member();

        member.setName("woochanleee");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

//        Assertions.assertEquals(member, result);
//        Assertions.assertThat(member).isEqualTo(result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();

        member1.setName("woochanleee1");
        repository.save(member1);

        Member member2 = new Member();
// shift + f6: 같은 변수명 동시에 수정하기
        member2.setName("woochanleee2");
        repository.save(member2);

        Member result = repository.findByName("woochanleee1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();

        member1.setName("woochanleee1");
        repository.save(member1);

        Member member2 = new Member();

        member2.setName("woochanleee2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
