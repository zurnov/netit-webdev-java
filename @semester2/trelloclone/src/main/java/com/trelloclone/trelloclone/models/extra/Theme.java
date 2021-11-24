package com.trelloclone.trelloclone.models.extra;

import com.trelloclone.trelloclone.models.pm.Board;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tm_theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    @OneToMany(mappedBy = "theme")
    private List<Board> boards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
}
