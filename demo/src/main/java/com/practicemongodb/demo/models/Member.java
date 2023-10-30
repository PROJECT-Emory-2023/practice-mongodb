package com.practicemongodb.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Member {

    @Id
    private int id;
    private String name;
    private String teamName;
    private int contributions;

    public Member() {
        id = -1;
        name = "test";
        teamName = "test";
        contributions = -1;
    }

    public Member(int id, String name, String teamName) {
        this.id = id;
        this.name = name;
        this.teamName = teamName;
        contributions = 0;
    }

    public void contribute() {
        contributions++;
    }

    public void contribute(int x) {
        contributions += x;
    }
}
