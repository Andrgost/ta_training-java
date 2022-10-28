package com.epam.training.aleksandr_gostev.main_task;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private final int groupNumber;
    private final ArrayList<Student> students = new ArrayList<>();

    public Group(int groupNumber) {
        this.groupNumber = groupNumber;
        groupInit();
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    private void groupInit() {
        students.add(new Student("Vasya"));
        students.add(new Student("Sveta"));
        students.add(new Student("Petya"));
        students.add(new Student("Klava"));
    }
}
