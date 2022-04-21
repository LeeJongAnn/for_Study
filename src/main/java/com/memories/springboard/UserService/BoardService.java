package com.memories.springboard.UserService;


import com.memories.springboard.Entity.Board;
import com.memories.springboard.Entity.User;
import com.memories.springboard.Repository.BoardRepository;
import com.memories.springboard.config.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BoardService {


    @Autowired
    private BoardRepository boardRepository;

    public void 글쓰기(Board board, User user) {
        board.setUser(user);
        board.setCount(0);
        boardRepository.save(board);
    }

    public Page<Board> boardList(int count) {
        Pageable pageable = PageRequest.of(count-1,4);
        return boardRepository.findAll(pageable);
    }
}
