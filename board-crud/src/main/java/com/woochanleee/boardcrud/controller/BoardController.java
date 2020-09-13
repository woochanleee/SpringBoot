package com.woochanleee.boardcrud.controller;

import com.woochanleee.boardcrud.dto.BoardDto;
import com.woochanleee.boardcrud.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;


    /* 게시글 목록 */
    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardList();

        model.addAttribute("boardList", boardList);
        return "board/list.html";
    }

    @GetMapping("/post")
    public String write() {
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);

        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);

        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDto) {
        System.out.println("what?");
        boardService.savePost(boardDto);

        return "redirect:/";
    }

    @DeleteMapping("/post/{no}")
    public void delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }
}
/*
    @Controller:
    - 컨트롤러임을 명시하는 어노테이션이다.
    - MVC에서 컨트롤러로 명시된 클래스의 메서드들은 반환 값으로 템플릿 경로를 작성하거나, redirect를 해줘야 한다.
        - 템플릿 경로는 templates 패키지를 기준으로한 상대경로이다.

    - @RestController도 존재하는데, 이는 @Controller, @ResponseBody가 합쳐진 어노테이션이다.
        - view 페이지가 필요없는 API 응답에 어울리는 어노테이션이다.

    @AllArgsConstructor:
    - Bean 주입 방식과 관련이 있으며, 생성자로 Bean 객체를 받는 방식을 해결해주는 어노테이션입니다. 그래서 BoardService 객체를 주입 받을 때 @Autowired 같은 특별한 어노테이션을 부여하지 않았습니다. ( 참고 )
    - 그 밖에, @NoArgsConstructor @RequiredArgsConstructor 어노테이션이 있다.

    @GetMapping / @PostMapping:
    URL을 매핑해주는 어노테이션이며, HTTP Method에 맞는 어노테이션을 작성하면 된다.

    dto는 Controller와 Service 사이에서 데이터를 주고 받는 객체를 의미한다.

    public String list(Model model) { ... }
    - Model 객체를 통해 View에 데이터를 전달한다.
*/