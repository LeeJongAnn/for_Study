package com.memories.springboard;


import com.memories.springboard.Entity.User;
import com.memories.springboard.Repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("유저 객체의 생성에 대한 테스트이다.")
    public void firstTest(){

        User oneUser = new User("HongGildong","asdf1234","LaLaland@naver.com");
        User oneUserSave = userRepository.save(oneUser);

        assertThat(oneUserSave.getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("다수의 유저 객체를 생성하기 위한 테스트이다.")
    public void secondTest(){
        User secondUser = new User("Kim","test1234","love1234@naver.com");
        User thirdUser= new User("ChooChoo","test2468","lovely1234@gmail.com");
        User forthUser = new User("UbiSoft","soso1414","UbiCare@naver.com");
        List<User> list = new ArrayList<User>();
        list.add(secondUser);
        list.add(thirdUser);
        list.add(forthUser);
        for(User showList: list) {
            System.out.println(showList.toString());
        }

        userRepository.saveAll(list);
    }

    @Test
    @DisplayName("유저 객체를 얻어오고 가지고 온 것을 수정하며 테스트한다.")
    public void thirdTest(){
         User user = userRepository.findById(1).get();
         user.setUsername("dlwhddksiq");
         user.setEmail("dlwhddksiq@naver.com");
         System.out.println(user.toString());
    }

}
