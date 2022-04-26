package com.memories.springboard.UserService;


import com.memories.springboard.Entity.Board;
import com.memories.springboard.Entity.Reply;
import com.memories.springboard.Entity.User;
import com.memories.springboard.Repository.BoardRepository;
import com.memories.springboard.Repository.ReplyRepository;
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

    @Autowired
    private ReplyRepository replyRepository;

    public void 글쓰기(Board board, User user) {
        board.setUser(user);
        board.setCount(0);
        boardRepository.save(board);
    }

    public Page<Board> boardList(int count) {
        Pageable pageable = PageRequest.of(count-1,4);
        return boardRepository.findAll(pageable);
    }

    public Board getBoardId(int id){

        return boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 상세보기 실패 : 해당 글을 찾을 수 없습니다.");
        });
    }
    @Transactional
    public void 글삭제하기(int id){
         boardRepository.deleteById(id);
    }


    @Transactional
    public void 글수정하기(int id, Board requestBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
                });
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
    }

    @Transactional
    public void 댓글쓰기(User user, int boardId, Reply requestReply) {

        Board board = boardRepository.findById(boardId).orElseThrow(()->{
            return new IllegalArgumentException("댓글 쓰기 실패 : 게시글 id를 찾을 수 없습니다.");
        });

        requestReply.setUser(user);
        requestReply.setBoard(board);

        replyRepository.save(requestReply);
    }
    @Transactional
    public void 댓글삭제(int id){
        replyRepository.deleteById(id);
    }
}
