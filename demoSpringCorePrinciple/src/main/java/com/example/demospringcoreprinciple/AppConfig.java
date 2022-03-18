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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
