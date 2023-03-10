package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 1. Template 방식
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","spring!!");
        return "hello";
    }

    // 외부에서 파라미터 받아서 보내기
    // required : default ( true , 파라미터를 넘겨야한다)
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    // 2. API 방식
    @GetMapping("hello-string")
    @ResponseBody // body 부분에 이 데이터를 직접 넣어주겠다.
    public String hellostring(@RequestParam("name") String name){
        return "hello " + name; // "hello {name}" 보냄
    }
    // 템플릿 엔진과의 차이로 viewResolver가 없고 이 문자가 그대로 간다.

    // API (JSON)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
