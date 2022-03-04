package com.example.demospringcoreprinciple.order;

import com.example.demospringcoreprinciple.member.Grade;
import com.example.demospringcoreprinciple.member.Member;
import com.example.demospringcoreprinciple.member.MemberService;
import com.example.demospringcoreprinciple.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    MemberService memberService=new MemberServiceImpl();
    OrderService orderService=new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}