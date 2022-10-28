package com.epam.training.aleksandr_gostev.main_task;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private final String facultyName;
    private final ArrayList<Group> groups = new ArrayList<>();

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
        groupInit();
    }

    public String getFacultyName() {
        return facultyName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    private void groupInit() {
        groups.add(new Group(111));
        groups.add(new Group(222));
        groups.add(new Group(333));
        groups.add(new Group(444));
    }
}
