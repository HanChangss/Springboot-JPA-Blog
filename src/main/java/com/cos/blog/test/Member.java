package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Getter,Setter 동시에 쓸려면 Data 어노테이션으로 !!
@AllArgsConstructor //전생성자를 하고싶을때는 해당 어노테이션으로!!
@NoArgsConstructor //빈생성자 @Builder라는 어노테이션을 생성자에 추가하면 불러올때 원하는 값만 불러 올수 있음 ex) Member m = Member.builder().불러오고 싶은값.build();
public class Member {
    private int id;
    private String username;
    private String password;
    private String email;
}
