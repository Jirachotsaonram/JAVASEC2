class Subject {
    private String subjectId;
    private String name;
    private double credit;
    private List<Teacher> teacherList;

    public Subject(String subjectId, String name, double credit) {
        this.subjectId = subjectId;
        this.name = name;
        this.credit = credit;
        this.teacherList = new ArrayList<>();
    }

    public void addNewTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    public String getName() {
        return name;
    }

    public String getTeachers() {
        List<String> teacherNames = new ArrayList<>();
        for (Teacher t : teacherList) {
            teacherNames.add(t.getName());
        }
        return String.join(", ", teacherNames);
    }
}