package hello.core.member;

public class MemberServiceImpl implements MemberService{


    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 인터페이스를 의존하고 할당하는부분이 구현체를 의존한다. DIP 위반하고 있는거여서 변경할때 어려움이 있다.
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
