package com.memories.springboard.UserService;


import com.memories.springboard.Entity.Board;
import com.memories.springboard.Entity.User;
import com.memories.springboard.Repository.BoardRepository;
import com.memories.springboard.config.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {


    @Autowired
    private BoardRepository boardRepository;

    public void 글쓰기(Board board, User user){
        board.setUser(user);
        board.setCount(0);
        boardRepository.save(board);
    }

    public List<Board> boardList(Board board){
        return boardRepository.findAll();
    }
}