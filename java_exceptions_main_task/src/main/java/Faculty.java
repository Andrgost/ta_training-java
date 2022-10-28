import java.util.ArrayList;

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

    public ArrayList<Group> getGroups() {
        return groups;
    }

    private void groupInit() {
        groups.add(new Group(111));
        groups.add(new Group(222));
        groups.add(new Group(333));
        groups.add(new Group(444));
    }
}
