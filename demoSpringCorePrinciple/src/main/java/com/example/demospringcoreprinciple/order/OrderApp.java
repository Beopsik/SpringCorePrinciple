package com.example.demospringcoreprinciple.order;

import com.example.demospringcoreprinciple.AppConfig;
import com.example.demospringcoreprinciple.member.Grade;
import com.example.demospringcoreprinciple.member.Member;
import com.example.demospringcoreprinciple.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService=applicationContext.getBean("orderService", OrderService.class);

        Long memberId=1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order="+order);
    }
}
