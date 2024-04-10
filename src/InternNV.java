public class InternNV extends EmployeeNV{
    private String majors;
    private String semester;
    private String universityName;
    public InternNV(int ID, String fullName, String birthDay, String phone, String email, String employeeType, String majors, String semester, String universityName) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public String getSemester() {
        return semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Majors: " + majors);
        System.out.println("Semester: " + semester);
        System.out.println("University Name: " + universityName);
    }
}
