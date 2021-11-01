package com.trelloclone.trelloclone.models.extra;

import com.trelloclone.trelloclone.models.users.User;
import com.trelloclone.trelloclone.models.pm.Card;

import javax.persistence.*;

@Entity
@Table(name = "td_comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    private Card card;

    @ManyToOne
    private User owner;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
