import java.util.*;


class Teacher {
    private String teacherId;
    private String name;
    private String lastName;
    private String email;
    private String phone;

    public Teacher(String teacherId, String name, String lastName, String email, String phone) {
        this.teacherId = teacherId;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name + " " + lastName;
    }
}