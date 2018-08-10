package com.project.packman.packman.model.CalorieBurners;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Document
public class Team implements Serializable {

    @Id
    private String id;
    @NotNull
    private String teamName;
    @Size(min = 5, max = 5)
    private List<User> userList;

    public Team() {
        this.userList = IntStream.range(0, 5).mapToObj(i -> new User()).collect(Collectors.toList());
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        this.userList.add(user);
    }

    public int getActivityInMinutesForTeam(){
        return userList.stream().mapToInt(User::getActivitesSumTime).sum();
    }

}
