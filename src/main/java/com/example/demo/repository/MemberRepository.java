package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //회원저장
    Member save(Member member);
    //회원 id 검색
    Optional<Member> findById(Long id);
    //회원 이름 검색
    Optional<Member> findByName(String name);
    //모든 회원 검색
    List<Member> findAll();
}
