package com.example.demospringcoreprinciple.order;

import com.example.demospringcoreprinciple.discount.DiscountPolicy;
import com.example.demospringcoreprinciple.discount.FixDiscountPolicy;
import com.example.demospringcoreprinciple.member.Member;
import com.example.demospringcoreprinciple.member.MemberRepository;
import com.example.demospringcoreprinciple.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository=new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy=new FixDiscountPolicy();
    
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
