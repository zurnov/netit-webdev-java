package com.trelloclone.trelloclone.services.data;

import java.util.List;

import javax.persistence.EntityManager;

import com.trelloclone.trelloclone.models.pm.BoardList;
import com.trelloclone.trelloclone.repositories.pm.BoardListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.trelloclone.trelloclone.models.extra.Theme;
import com.trelloclone.trelloclone.models.pm.Board;
import com.trelloclone.trelloclone.models.users.User;
import com.trelloclone.trelloclone.repositories.extra.ThemeRepository;
import com.trelloclone.trelloclone.repositories.pm.BoardRepository;
import com.trelloclone.trelloclone.services.auth.UserLogin;

import javax.persistence.Query;

@Component
public class BoardDataService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private BoardListRepository boardListRepository;

    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    public List<Board> getBoardsByWorkspace(int id) {

        Authentication auth 		= SecurityContextHolder.getContext().getAuthentication();
        UserLogin currentUserModel 	= (UserLogin)auth.getPrincipal();

        return this.boardRepository.findByWorkspaceId(id, currentUserModel.getUserId());
    }

    public List<BoardList> getBoardLists(int boardId){
        return this.boardListRepository.findAllByBoardId(boardId);
    }

    public Board createBoard(Board entity, int workspaceId) {

        Authentication auth 		= SecurityContextHolder.getContext().getAuthentication();
        UserLogin currentUserModel 	= (UserLogin)auth.getPrincipal();

        entity.setWorkspaceId(workspaceId);
        entity.setMembers(currentUserModel.getUser());

        return this.boardRepository.save(entity);
    }

    public void createBoardList(BoardList entity, int boardId){

        entity.setBoardId(boardId);
        this.boardListRepository.save(entity);

    }

}