package com.cos.blog.test;

import java.util.List;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DummyControllerTest {
    
    @Autowired //의존성 주입(DI)
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id) {
        try {
            userRepository.deleteById(id);

        } catch(Exception e) {
            return "삭제에 실패하였습니다. 해당id는 DB에 없습니다.";
        }        
        
        return "삭제되었습니다.id : " + id;
    }

    //save 함수는 id를 전달하지 않으며 insert를 해주고
    //save 함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update해주고
    //save 함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 해요.
    @Transactional //함수 종료시에 자동 commit이 됨.
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        System.out.println("id : " + requestUser.getId() );
        System.out.println("password : " + requestUser.getPassword());
        

        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalAccessError("수정에 실패하였습니다.");
        });
        
        user.setEmail("hth4757@naver.com");

        //userRepository.save(user);
        //
        return user;
    }

    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    //한페이지당 2건씩 가져온다
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pagingUser = userRepository.findAll(pageable);

        List<User> users = pagingUser.getContent();
        return users;
    }


    @PostMapping("/dummy/join")
    public String join(User user) {
        user.setUsermame("한창현");
        user.setEmail("chang@andwise.com");
        user.setPassword("password");
        user.setRole(RoleType.USER);
        userRepository.save(user);
        System.out.println("111");
        return "회원가입이 완료되었습니다.";
    }
}
