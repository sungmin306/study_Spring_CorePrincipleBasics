package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //    private final MemberRepository memberRepository = new MemoryMemberRepository();  // 회원 찾아야하고
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 할인정책 찾아야함
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // final은 값이 무조건 할당되어야함
    //private DiscountPolicy discountPolicy; // 인터페이스에만 의존함
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //단일책임원칙을 잘 지킴
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

