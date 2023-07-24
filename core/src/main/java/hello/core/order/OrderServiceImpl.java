package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();  // 회원 찾아야하고
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 할인정책 찾아야함
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //단일책임원칙을 잘 지킴
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

