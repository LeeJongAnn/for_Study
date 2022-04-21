package com.memories.springboard.Controller;

import com.memories.springboard.Entity.Board;
import com.memories.springboard.Repository.BoardRepository;
import com.memories.springboard.UserService.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/boardForm")
    public String viewboardForm(){
        return "Board_form";
    }

    @GetMapping("/board/view/{count}")
    public String viewboardPage(@PathVariable int count, Board board, Model model){
        Page<Board> everyBoard = boardService.boardList(count);
        List<Board> content = everyBoard.getContent();
        model.addAttribute("count",count);
        model.addAttribute("everyBoard",content);
        model.addAttribute("everyPage",everyBoard.getTotalPages());
        return  "Board_index";
    }
}
