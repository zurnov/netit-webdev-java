package com.trelloclone.trelloclone.repositories.pm;

import com.trelloclone.trelloclone.models.pm.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Integer> {
}
