package com.trelloclone.trelloclone.repositories.pm;

import com.trelloclone.trelloclone.models.pm.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Integer> {

    @Query(value = "SELECT" +
            " a.* " +
            " FROM " +
            " td_boards a, " +
            " td_workspaces b, " +
            " tc_workspace_members c " +
            " WHERE a.workspace_id = b.id " +
            " AND c.workspace_id = b.id " +
            " AND a.is_visible = 1 " +
            " AND a.workspace_id = ? " +
            " AND c.user_id = ? ", nativeQuery = true)
    public List<Board> findByWorkspaceId(int workspaceId,int userId);
}
