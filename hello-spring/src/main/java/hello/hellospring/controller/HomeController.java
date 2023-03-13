package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Spring Container에서 매핑 된 것을 먼저 찾기 떄문에 index.html이 아닌 home.html이 나오는 것 이다.
    @GetMapping("/")
    public String Home(){
        return "home";
    }
}
