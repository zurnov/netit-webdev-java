package com.trelloclone.trelloclone.models.pm;

import com.trelloclone.trelloclone.enums.BoardVisibility;
import com.trelloclone.trelloclone.models.extra.Theme;
import com.trelloclone.trelloclone.models.users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "td_boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private BoardVisibility isVisible;

    @ManyToOne
    private Theme theme;

    @JoinColumn(name="workspace_id", insertable = false, updatable = false)
    @ManyToOne
    private Workspace workspace;

    @Column(name="workspace_id")
    private int workspaceId;

    @OneToMany(mappedBy = "board")
    private List<BoardList> boardlists;

    @ManyToMany
    @JoinTable(
            name				= "tc_board_members",
            joinColumns 		= @JoinColumn(name="board_id"),
            inverseJoinColumns 	= @JoinColumn(name="user_id")
    )
    private List<User> members;

    public Board() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public int getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(int workspaceId) {
        this.workspaceId = workspaceId;
    }

    public List<BoardList> getBoardlists() {
        return boardlists;
    }

    public void setBoardlists(List<BoardList> boardlists) {
        this.boardlists = boardlists;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public void setMembers(User singleMember) {

        ArrayList<User> userCollection = new ArrayList<>();
        userCollection.add(singleMember);

        this.members = userCollection;
    }

    public BoardVisibility getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(BoardVisibility isVisible) {
        this.isVisible = isVisible;
    }

}
