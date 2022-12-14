package com.epam.training.aleksandr_gostev.main_task;

import com.epam.training.aleksandr_gostev.main_task.Custom_exceptions.FacultyException;
import com.epam.training.aleksandr_gostev.main_task.Custom_exceptions.MarkException;
import com.epam.training.aleksandr_gostev.main_task.Custom_exceptions.StudentException;
import com.epam.training.aleksandr_gostev.main_task.Custom_exceptions.SubjectException;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Statistic {
    public static void main(String[] args) {
        Student student = new Student("St1");
        try {
            System.out.println("Average mark of " + student.getStudentName() +
                    " is " + studentAverageMark(student));
        } catch (MarkException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getMark());
        } catch (SubjectException e) {
            System.out.println(e.getMessage());
        }

        String subjectOne = "Cybersport";
        Group group = new Group(222);
        Faculty faculty = new Faculty("DMF");
        try {
            System.out.println("Average mark of subject " + subjectOne +
                    " is " + subjectAverageMarkByGroupAndFaculty(subjectOne, group, faculty));
        } catch (StudentException e) {
            System.out.println(e.getMessage());
        }

        String subjectTwo = "History";
        University university = new University();
        try {
            System.out.println("Average mark of subject " + subjectTwo +
                    " by university is " + subjectAverageMarkByUniversity(subjectTwo, university));
        } catch (FacultyException | StudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double studentAverageMark(Student student) throws MarkException, SubjectException {
        if (student.getSubjectMarks().isEmpty()) throw new SubjectException("Subject is absent");

        List<Integer> list = student.getSubjectMarks().values().stream()
                .filter(mark -> mark < 0 || mark > 10)
                .toList();

        if (!list.isEmpty()) throw new MarkException(String.format("Marks are found: %s", list));

        return student.getSubjectMarks().values().stream()
                .mapToInt(x -> x).average().getAsDouble();
    }

    private static double subjectAverageMarkByGroupAndFaculty(String subject, Group group, Faculty faculty) throws StudentException {
        AtomicReference<Double> sum = new AtomicReference<>(0.0);
        AtomicInteger count = new AtomicInteger();

        faculty.getGroups().stream()
                .filter(gr -> gr.getGroupNumber() == group.getGroupNumber())
                .map(Group::getStudents)
                .forEach(students -> students
                        .forEach(student -> student.getSubjectMarks().entrySet().stream()
                                .filter(subj -> subj.getKey().equals(subject))
                                .forEach(subj -> {
                                    sum.updateAndGet(v -> v + subj.getValue());
                                    count.getAndIncrement();
                                })));

        return sum.get() / count.get();
    }

    private static double subjectAverageMarkByUniversity(String subject, University university)
            throws FacultyException, StudentException {
        if (university.getFaculties().isEmpty()) throw new FacultyException("Faculty is absent");

        AtomicReference<Double> sum = new AtomicReference<>(0.0);
        AtomicInteger count = new AtomicInteger();

        university.getFaculties().stream()
                .map(Faculty::getGroups)
                .forEach(groups -> groups
                        .forEach(group -> group.getStudents()
                                .forEach(student -> student.getSubjectMarks().entrySet().stream()
                                        .filter(subj -> subj.getKey().equals(subject))
                                        .forEach(subj -> {
                                            sum.updateAndGet(v -> v + subj.getValue());
                                            count.getAndIncrement();
                                        }))));

        return sum.get() / count.get();
    }
}
