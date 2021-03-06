package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//스프링이 com.cos.blog 패키지 이하를 스캔해서 모든 파일들을 메모리에 new 하는것이 아니라
//특정 어노테이션이 붙어있는 클래스 파일들을 new()해서(ioc) 스프링 컨테이너를 관리해준다.
@RestController
public class BlogControllerTest {
    
    @GetMapping("/test/hello")
    public String hello() {
       return "<h1>hello spring boot</h1>";
    }
}
