package com.trelloclone.trelloclone.models.pm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="td_boardlists")
public class BoardList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @JoinColumn(name = "board_id", insertable = false,updatable = false)
    @ManyToOne
    private Board board;

    @Column(name = "board_id")
    private int boardId;


    @OneToMany(mappedBy = "boardList")
    private List<Card> cards;

    public BoardList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
