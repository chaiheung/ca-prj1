package com.caprj1.controller;

import com.caprj1.domain.Board;
import com.caprj1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/add")
    public String add() {
        return "board/add";
    }

    @PostMapping("/add")
    public String addPost(Board board, RedirectAttributes rttr) {
        System.out.println("board = " + board);
        service.add(board);

        rttr.addAttribute("id", board.getId());
        return "redirect:/board";
    }

    // /board?id=1
    @GetMapping("/board")
    public String view(Integer id, Model model) {
        // 게시물 조회(select)
        Board board = service.get(id);
        // 모델에 넣고
        model.addAttribute("board", board);
        // jsp 로 포워드
        return "board/view";
    }

    // ?page=2
    @GetMapping("/")
    public String home(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        // 게시물 목록 조회(select)
        // 모델에 넣고
        model.addAttribute("boardList", service.list(page));
        // jsp 로 포워드
        return "board/home";
    }

    // 삭제
    @PostMapping("delete")
    public String delete(Integer id, RedirectAttributes rttr) {
        service.remove(id);

        return "redirect:/";
    }

    // 수정
    @GetMapping("/modify")
    public String modifyForm(Integer id, Model model) {
        // 조회해서
        // 모델에 넣고
        model.addAttribute("board", service.get(id));
        // view 로 포워드
        return "board/modify";
    }

    @PostMapping("/modify")
    public String modifyPost(Board board, RedirectAttributes rttr) {
        service.modify(board);
        rttr.addAttribute("id", board.getId());
        return "redirect:/board";
    }
}
