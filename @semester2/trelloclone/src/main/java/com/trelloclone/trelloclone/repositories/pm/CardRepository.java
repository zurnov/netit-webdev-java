package com.trelloclone.trelloclone.repositories.pm;

import com.trelloclone.trelloclone.models.pm.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
