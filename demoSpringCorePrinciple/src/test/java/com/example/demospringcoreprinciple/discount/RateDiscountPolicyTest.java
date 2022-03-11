package com.example.demospringcoreprinciple.discount;

import com.example.demospringcoreprinciple.member.Grade;
import com.example.demospringcoreprinciple.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy=new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void discount_O() {
        // Given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // When
        int discount = rateDiscountPolicy.discount(member, 10000);

        //Then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아닌 고객은 10% 할인이 적용되지 않아야 한다..")
    void discount_X() {
        // Given
        Member member = new Member(1L, "memberBasic", Grade.BASIC);

        // When
        int discount = rateDiscountPolicy.discount(member, 10000);

        //Then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}