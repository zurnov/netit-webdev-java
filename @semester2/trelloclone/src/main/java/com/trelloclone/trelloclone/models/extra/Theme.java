package com.trelloclone.trelloclone.models.extra;

import com.trelloclone.trelloclone.models.pm.Board;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tm_theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String title;
    @OneToMany(mappedBy = "theme")
    private List<Board> boards;
}
