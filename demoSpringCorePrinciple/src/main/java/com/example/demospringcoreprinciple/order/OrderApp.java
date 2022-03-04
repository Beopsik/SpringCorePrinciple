package com.example.demospringcoreprinciple.order;

import com.example.demospringcoreprinciple.member.Grade;
import com.example.demospringcoreprinciple.member.Member;
import com.example.demospringcoreprinciple.member.MemberService;
import com.example.demospringcoreprinciple.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService=new MemberServiceImpl();
        OrderService orderService=new OrderServiceImpl();

        Long memberId=1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order="+order);
    }
}
