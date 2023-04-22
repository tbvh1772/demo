package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    //메서드 실행종료시 동작하는 메서드
    //테스트는 의존관계없이 구현해야함
    @AfterEach
    public void afterEach(){
        //기존 객체 데이터 초기화
        repository.clearStore();
    }

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //Optional 객체의 값을 가져오기 위해.get() 사용
        Member result = repository.findById(member.getId()).get();
        //성공 : 로그남지않음 , 실패: 실패로그남음
        Assertions.assertEquals(member,result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertEquals(result,member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertEquals(result.size(),2);
    }
}
