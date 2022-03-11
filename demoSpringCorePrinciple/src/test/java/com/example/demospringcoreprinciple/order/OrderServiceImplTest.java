package com.example.demospringcoreprinciple.order;

import com.example.demospringcoreprinciple.AppConfig;
import com.example.demospringcoreprinciple.member.Grade;
import com.example.demospringcoreprinciple.member.Member;
import com.example.demospringcoreprinciple.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    AppConfig appConfig=new AppConfig();
    MemberService memberService=appConfig.memberService();
    OrderService orderService=appConfig.orderService();

    @Test
    void createOrder() {
        Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}