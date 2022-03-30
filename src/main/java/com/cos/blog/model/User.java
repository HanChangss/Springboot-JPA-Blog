package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//ORM ->JAVA Obejct -> 테이블로 만들어주는 기술
@Entity //user클래스가 mysql테이블이 자동으로 생성된다
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.TABLE) //프로젝트에서 연결된 DB의 넘버링 전략을따라간다.
    private int id;

    @Column(nullable = false, length = 30)
    private String usermame;

    @Column(nullable = false, length = 100)
    private String password;
    
    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'user'")
    private String role; //Enum을 쓰는게 좋다. //권한 ... 잘못된 값을 넣지 않도록 범위를 정해주는 역활

    @CreationTimestamp //시간이 자동 입력
    private Timestamp createDate;
}
