package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // MemberController가 생성 될 때 스프링 빈에 등록되어 있는 MemberService 객체를 주입해준다 => DI(의존관계 주입)
    @Autowired // Spring Container 에서 MemberService 객체를 가져온다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
