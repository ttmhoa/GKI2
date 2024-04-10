public class Experience extends EmployeeNV{
    private int expInYear;
    private String proSkill;
    public Experience(int ID, String fullName, String birthDay, String phone, String email, String employeeType, int expInYear, String proSkill) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("expInYear: " + expInYear);
        System.out.println("proSkill: " + proSkill);
    }
}
