import java.util.ArrayList;

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

    public ArrayList<Student> getStudents() {
        return students;
    }

    private void groupInit() {
        students.add(new Student("Vasya"));
        students.add(new Student("Sveta"));
        students.add(new Student("Petya"));
        students.add(new Student("Klava"));
    }
}
