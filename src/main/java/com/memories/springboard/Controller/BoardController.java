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
        return "Board/Board_form";
    }

    @GetMapping("/board/view/detail/{id}")
    public String viewboardDetail(@PathVariable int id,Model model){
        Board boardDetail = boardService.getBoardId(id);
        model.addAttribute("boardDetail",boardDetail);
        return "Board/Board_detail";

    };

    @GetMapping("/board/view/{count}")
    public String viewboardPage(@PathVariable int count, Board board, Model model){
        Page<Board> everyBoard = boardService.boardList(count);
        List<Board> content = everyBoard.getContent();

        model.addAttribute("count",count);
        model.addAttribute("everyBoard",content);
        model.addAttribute("everyPage",everyBoard.getTotalPages());
        return  "Board/Board_index";
    }
}
