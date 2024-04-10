public class FresherNV extends EmployeeNV{
    private String graduationDate;
    private String graduationRank;
    private String education;
    public FresherNV(int ID, String fullName, String birthDay, String phone, String email, String employeeType, String graduationDate, String graduationRank, String education) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("graduationDate: " + graduationDate);
        System.out.println("graduationRank: " + graduationRank);
        System.out.println("education: " + education);
    }
}
