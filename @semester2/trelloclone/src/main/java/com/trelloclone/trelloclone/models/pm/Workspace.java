package com.trelloclone.trelloclone.models.pm;

import com.trelloclone.trelloclone.enums.WorkspaceType;
import com.trelloclone.trelloclone.models.users.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="td_workspaces")
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private WorkspaceType type;
    private String description;

    @ManyToOne()
    private User owner;

    @OneToMany(mappedBy = "workspace")
    private List<Board> boards;

    //Many to many
    @ManyToMany
    @JoinTable(
            name =                  "tc_workspace_members",
            joinColumns =           @JoinColumn(name = "workspace_id"),
            inverseJoinColumns =    @JoinColumn(name = "user_id")
    )
    private List<User> members;


    public Workspace() {
    }

    public Workspace(String title, WorkspaceType type, String description) {
        this.title = title;
        this.type = type;
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WorkspaceType getType() {
        return type;
    }

    public void setType(WorkspaceType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
