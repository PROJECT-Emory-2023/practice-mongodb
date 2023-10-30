package com.practicemongodb.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practicemongodb.demo.models.Member;
import com.practicemongodb.demo.repository.MemberRepository;

@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepo; // inject database

    // CREATE

    @PostMapping("/members/new")
    public Member createMember(@RequestBody Member member) {
        memberRepo.save(member);
        return member;
    }

    // READ

    @GetMapping("/members")
    public List<Member> getMembers() {
        return memberRepo.findAll();
    }

    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable int id) {
        return memberRepo.findMemberById(id);
    }

    @GetMapping("/{team}")
    public List<Member> getTeamMembers(@PathVariable String team) {
        return memberRepo.findAll(team);
    }

    // UPDATE

    @PutMapping("members/contribute/{name}")
    public Member contribute(@PathVariable String name) {
        Member member = memberRepo.findMemberByName(name);
        member.contribute();
        member = memberRepo.save(member);
        return member;
    }

    // DELETE

    @DeleteMapping("/members/delete/{id}")
    public Member delete(@PathVariable int id) {
        Member member = memberRepo.findMemberById(id);
        memberRepo.deleteById(id);
        return member;
    }

    @DeleteMapping("/nuke")
    public boolean nuke() {
        memberRepo.deleteAll();
        return memberRepo.count() == 0;
    }
}
