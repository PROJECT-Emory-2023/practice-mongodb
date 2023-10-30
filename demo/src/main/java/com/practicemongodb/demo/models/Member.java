package com.practicemongodb.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("members") // if collection specified, data not saved
@Data
public class Member {

    @Id
    private Integer id;
    private String name;
    private String team;
    private int contributions;

    public Member() {
        id = -1;
        name = "test";
        team = "test";
        contributions = 0;
    }

    public Member(int id, String name, String team) {
        this.id = id;
        this.name = name;
        this.team = team;
        contributions = 0;
    }

    public void contribute() {
        contributions++;
    }

    public void contribute(int x) {
        contributions += x;
    }
}
