package com.trelloclone.trelloclone.repositories.extra;

import com.trelloclone.trelloclone.models.extra.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
