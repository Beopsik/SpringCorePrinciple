package com.example.demospringcoreprinciple.order;

import com.example.demospringcoreprinciple.AppConfig;
import com.example.demospringcoreprinciple.member.Grade;
import com.example.demospringcoreprinciple.member.Member;
import com.example.demospringcoreprinciple.member.MemberService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService();
        OrderService orderService=appConfig.orderService();

        Long memberId=1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order="+order);
    }
}
