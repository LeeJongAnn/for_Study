package com.memories.springboard.Controller;

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

    @GetMapping("/boardForm")
    public String viewboardForm(){
        return "Board_form";
    }

    @GetMapping("/board/view")
    public String viewboardPage(Board board, Model model){
        List<Board> everyBoard = boardService.boardList();
        model.addAttribute("everyBoard",everyBoard);
        return  "Board_index";
    }
}
