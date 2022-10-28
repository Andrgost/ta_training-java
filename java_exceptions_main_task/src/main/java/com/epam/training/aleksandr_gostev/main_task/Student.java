package com.epam.training.aleksandr_gostev.main_task;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private final String studentName;
    private final Map<String, Integer> subjectMarks = new HashMap<>();

    public Student(String studentName) {
        this.studentName = studentName;
        subjectsInit();
    }

    public String getStudentName() {
        return studentName;
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }

    private void subjectsInit() {
        subjectMarks.put("Math", 8);
        subjectMarks.put("Literature", 7);
        subjectMarks.put("Cybersport", 9);
        subjectMarks.put("History", 6);
        subjectMarks.put("Physics", 9);
    }

}
