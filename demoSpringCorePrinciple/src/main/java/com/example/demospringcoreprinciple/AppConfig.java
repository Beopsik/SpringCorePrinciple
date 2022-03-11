package com.example.demospringcoreprinciple;

import com.example.demospringcoreprinciple.discount.FixDiscountPolicy;
import com.example.demospringcoreprinciple.member.MemberService;
import com.example.demospringcoreprinciple.member.MemberServiceImpl;
import com.example.demospringcoreprinciple.member.MemoryMemberRepository;
import com.example.demospringcoreprinciple.order.OrderService;
import com.example.demospringcoreprinciple.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
