package com.example.demospringcoreprinciple;

import com.example.demospringcoreprinciple.discount.DiscountPolicy;
import com.example.demospringcoreprinciple.discount.FixDiscountPolicy;
import com.example.demospringcoreprinciple.discount.RateDiscountPolicy;
import com.example.demospringcoreprinciple.member.MemberRepository;
import com.example.demospringcoreprinciple.member.MemberService;
import com.example.demospringcoreprinciple.member.MemberServiceImpl;
import com.example.demospringcoreprinciple.member.MemoryMemberRepository;
import com.example.demospringcoreprinciple.order.OrderService;
import com.example.demospringcoreprinciple.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
