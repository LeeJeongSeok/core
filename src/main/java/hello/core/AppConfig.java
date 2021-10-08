package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig { // AppConfig 클래스는 배우를 캐스팅하는 일종의 공연 기획자라고 생각하자

    public MemberService memberService() { // 공연 기획자가 service라는 대본에 impl 이라는 어떤 배우를 캐스팅하는지 보여주는 코드라고 생각하자
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
