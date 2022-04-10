package com.example.demo.controller;

import com.example.demo.entity.Board;
import com.example.demo.entity.QBoard;
import com.example.demo.repository.BoardRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/")
@Slf4j
public class MainController {

    @Autowired private BoardRepository boardRepository;

    @Autowired private JPAQueryFactory jpaQueryFactory;

    private final QBoard qBoard = QBoard.board;

    @GetMapping
    public String routeRoot(
            @RequestParam(name = "code", required = false) Long code,
            Model model
    ) {

//        Board board = new Board();
//        board.setTitle("타이틀2");
//        board.setContents("콘텐츠2");
//        boardRepository.save(board);

//        Optional<Board> boardOptional = boardRepository.findById(1L);
//        Board board = null;
//        log.info(String.valueOf(boardOptional.isPresent()));
//        board = boardOptional.get();

        List<Board> boards = null;
        JPAQuery<Board> jpaQuery = jpaQueryFactory.select(qBoard).from(qBoard);
        if (code != null) {
            jpaQuery.where(qBoard.code.eq(code));
        }

        boards = jpaQuery.fetch();
        model.addAttribute("boards", boards);

        return "index";
    }

}
