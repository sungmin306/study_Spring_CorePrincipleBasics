package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 인터페이스를 의존하고 할당하는부분이 구현체를 의존한다. DIP 위반하고 있는거여서 변경할때 어려움이 있다.
    private MemberRepository memberRepository;

    @Autowired  // 자동으로 의존관계 주입 ac.getBean(MemberRepository.class와 비슷함
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
