package com.trelloclone.trelloclone.models.pm;

import com.trelloclone.trelloclone.models.users.User;
import com.trelloclone.trelloclone.models.extra.Comment;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "td_cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    private BoardList boardList;

    @ManyToOne
    private User author;

    //TODO: Annotate
    //private List<WorkspaceMember> members;

    @OneToMany(mappedBy = "card")
    private List<Comment> comments;
    @ManyToMany
    @JoinTable(
            name = "tc_card_members",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> members;

    public Card() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BoardList getBoardList() {
        return boardList;
    }

    public void setBoardList(BoardList boardList) {
        this.boardList = boardList;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
