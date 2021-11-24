package com.trelloclone.trelloclone.repositories.pm;

import com.trelloclone.trelloclone.models.pm.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkspaceRepository extends JpaRepository<Workspace,Integer> {
    public List<Workspace> getWorkspaceByOwnerId(Long id);
}
