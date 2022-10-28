import java.util.ArrayList;

public class University {
    private final ArrayList<Faculty> faculties = new ArrayList<>();

    public University() {
        groupInit();
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    private void groupInit() {
        faculties.add(new Faculty("F1"));
        faculties.add(new Faculty("F2"));
        faculties.add(new Faculty("F3"));
        faculties.add(new Faculty("F4"));
    }
}
