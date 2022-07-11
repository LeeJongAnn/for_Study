package com.memories.springboard.Controller;

import com.memories.springboard.Entity.Board;
import com.memories.springboard.Repository.BoardRepository;
import com.memories.springboard.UserService.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/boardForm")
    public String viewboardForm(){
        return "Board/Board_form";
    }

    @GetMapping("/boardForm/updateForm/{id}")
    public String viewboardUpdateForm(@PathVariable int id,Model model){
        Board boardDetail = boardService.getBoardId(id);
        model.addAttribute("boardDetail",boardDetail);
        return "Board/Board_updateForm";
    }

    @GetMapping("/board/view/detail/{id}")
    public String viewboardDetail(@PathVariable int id,Model model){
        Board boardDetail = boardService.getBoardId(id);
        model.addAttribute("boardDetail",boardDetail);
        return "Board/Board_detail";

    };

    @GetMapping("/board/view/{count}")
    public String viewboardPage(@PathVariable int count, Board board, Model model,@Param("classify")String classify, @Param("Direction") String Direction){
        Page<Board> everyBoard = boardService.boardList(count,classify,Direction);
        List<Board> content = everyBoard.getContent();

        String flip = Direction.equals("asc") ? "desc" : "asc";

        model.addAttribute("count",count);
        model.addAttribute("everyBoard",content);
        model.addAttribute("everyPage",everyBoard.getTotalPages());
        model.addAttribute("nowPage",count);
        model.addAttribute("classify",classify);
        model.addAttribute("Direction",Direction);
        model.addAttribute("flip",flip);
        return  "Board/Board_index";
    }

    @PostMapping("/api/reply/delete/{replyId}")
    public String replydelete(@PathVariable(name = "replyId")  int replyId, @Param("boardId") int boardId,
                              RedirectAttributes redirectAttributes){
        boardService.댓글삭제(replyId);
        redirectAttributes.addFlashAttribute("Call","해당 하는 댓글이 삭제되었습니다 :" + replyId);
        return "redirect:/board/view/detail/" + boardId;
    }
}
