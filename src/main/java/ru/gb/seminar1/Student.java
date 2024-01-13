package ru.gb.seminar1;

import lombok.Data;

@Data
public class Student {
    private static long countId = 1L;
    private final long id;
    private String name;
    private String groupName;

    public Student(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
        this.id = countId++;
    }
}
