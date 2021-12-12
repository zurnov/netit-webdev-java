package com.trelloclone.trelloclone.controllers;

import com.trelloclone.trelloclone.models.pm.Board;
import com.trelloclone.trelloclone.models.pm.BoardList;
import com.trelloclone.trelloclone.models.pm.Card;
import com.trelloclone.trelloclone.services.data.BoardDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class BoardController {

    @Autowired
    private BoardDataService boardDataService;

    @GetMapping("/boards/{id}")
    public String getBoardPage(@PathVariable int id, Model model) {

       var boardListCollection = this.boardDataService.getBoardLists(id);

        model.addAttribute("boardId", id);
        model.addAttribute("boardList", new BoardList());
        model.addAttribute("boardListCollection",boardListCollection);

        return "board/view";
    }
    @PostMapping("/boards/{id}")
    public RedirectView processBoard(@ModelAttribute BoardList entity,@PathVariable int id){

        this.boardDataService.createBoardList(entity,id);

        return new RedirectView("/boards/" + id);
    }
    @PostMapping("/boards/{boardId}/card/create")
    public void createCard(@PathVariable int boardId, @ModelAttribute Card entity){
        //TODO LOGIC FOR ADDING CARDS
    }
}