package model;

public class Teacher extends MyClass{
    private String teacherCode;

    public Teacher(String teacherCode,String name, String age, String sex, String phoneNumber, String className, String classCode) {
        super(name, age, sex, phoneNumber, className, classCode);
        this.teacherCode = teacherCode;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }
}
