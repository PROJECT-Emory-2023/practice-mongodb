package com.practicemongodb.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practicemongodb.demo.models.Member;
import com.practicemongodb.demo.repository.MemberRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    // "inject" necesssary code to use memberRepo as an instantiated object
    @Autowired
    MemberRepository memberRepo;

    @Override
    public void run(String... args) {
        System.out.println("\nCreate\n");
        addMembers();
        System.out.println("\nRead\n");
        showAllMembers();
        getMemberByName("Jack");
        getMemberByTeam("Project Pandas");
        getTotalMembers();
        System.out.println("\nUpdate\n");
        addContribution("John");
        System.out.println("\nDelete\n");
        deleteMember(3);
        showAllMembers();
    }

    // CREATE

    public void addMembers() {
        System.out.println("Adding dud members...");
        memberRepo.save(new Member(1, "John", "Project Pandas"));
        memberRepo.save(new Member(2, "Jane", "Project Pandas"));
        memberRepo.save(new Member(3, "Jack", "EagleXchange"));
        memberRepo.save(new Member(4, "Jill", "EagleXchange"));
        System.out.println("Done.");
    }

    // READ

    public void showAllMembers() {
        System.out.println("Showing all members...");
        memberRepo.findAll().forEach(member -> System.out.println(member));
    }

    public void getMemberByName(String name) {
        System.out.println("Fetching " + name + "...");
        Member member = memberRepo.findMemberByName(name);
        System.out.println(member);
    }

    public void getMemberByTeam(String team) {
        System.out.println("Getting all members of team " + team + "...");
        List<Member> members = memberRepo.findAll(team);
        members.forEach(member -> System.out.println("ID: " + member.getId() + ", Name: " + member.getName()));
        // note empty fields are filled in with defaults, only returns ID and Name
        members.forEach(member -> System.out.println(member));
    }

    public void getTotalMembers() {
        System.out.println("Number of members in Project Emory: " + memberRepo.count());
    }

    // UPDATE

    public void addContribution(String name) {
        Member member = memberRepo.findMemberByName(name);
        member.contribute();
        member = memberRepo.save(member);
        if (member != null)
            System.out.println(member.getName() + " successfully contributed once!");
    }

    // DELETE

    public void deleteMember(int id) {
        memberRepo.deleteById(id);
        System.out.println("Member #" + id + " deleted.");
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
