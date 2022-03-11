package com.example.demospringcoreprinciple.member;

import com.example.demospringcoreprinciple.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {
    AppConfig appConfig=new AppConfig();
    MemberService memberService=appConfig.memberService();
    
    @Test
    void join(){
        // Given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // When
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // Then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}