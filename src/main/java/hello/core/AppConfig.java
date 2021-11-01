package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // AppConfig 클래스는 배우를 캐스팅하는 일종의 공연 기획자라고 생각하자

    /**
     * 공연 기획자가 service라는 대본에 impl 이라는 어떤 배우를 캐스팅하는지 보여주는 코드라고 생각하자 (관심사 분리 강의 중)
     * AppConfig 리펙토링 강의 중 역할에 따른 구현이 잘 안보인다고 하는데..무슨 느낌인지 모르겠다..
     * 기존에 코드들을 보면 역할에 대한 구현이 한번에 뭉쳐서 이루어졌지만, 그것보단 각각의 역할별로 구현을 따로 만들어 하나의 역할에는 어떤 구현이 되어있는지 보기 쉽게 리펙토링한 것 같다.--> 내가 썻는데도 먼말인지 모르겠다
     */
    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
//        return new MemberServiceImpl(new MemoryMemberRepository()); 리펙토링 전 코드
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy()); 리펙토링 전 코드
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
