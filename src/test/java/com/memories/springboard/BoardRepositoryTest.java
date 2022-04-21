package com.memories.springboard;


import com.memories.springboard.Entity.Board;
import com.memories.springboard.Entity.User;
import com.memories.springboard.Repository.BoardRepository;
import com.memories.springboard.Repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    @DisplayName("Pagination Test")
    public void first(){
        int Number= 0;
        int pagesize = 4;
        Pageable pageable = PageRequest.of(Number,pagesize);
        Page<Board> PageBoard = boardRepository.findAll(pageable);
        List<Board> ListBoard = PageBoard.getContent();

        for (Board page : ListBoard){
            System.out.println(page);
        }
    }
}
