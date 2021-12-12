package com.trelloclone.trelloclone.repositories.pm;

import com.trelloclone.trelloclone.models.pm.BoardList;
import com.trelloclone.trelloclone.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardListRepository extends JpaRepository<BoardList,Integer> {

    public List<BoardList> findAllByBoardId(int boardId);

}
