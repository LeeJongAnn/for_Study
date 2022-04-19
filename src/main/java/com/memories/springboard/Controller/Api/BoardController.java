package com.memories.springboard.Controller.Api;

import com.memories.springboard.Entity.Board;
import com.memories.springboard.Repository.BoardRepository;
import com.memories.springboard.UserService.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/view")
    public String viewboardPage(Board board, Model model){
        List<Board> everyBoard = boardService.boardList(board);
        model.addAttribute("everyBoard",everyBoard);
        return  "board_index";
    }
}
