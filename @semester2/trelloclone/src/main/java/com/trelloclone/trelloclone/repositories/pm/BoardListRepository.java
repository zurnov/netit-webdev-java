package com.trelloclone.trelloclone.repositories.pm;

import com.trelloclone.trelloclone.models.pm.BoardList;
import com.trelloclone.trelloclone.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardListRepository extends JpaRepository<BoardList,Integer> {



}
