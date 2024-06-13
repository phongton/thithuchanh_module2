package model;

import java.util.Date;

public class Student extends MyClass{
    private String studentCode;


    public Student(String studentCode,String name, String age, String sex, String phoneNumber, String className, String classCode) {
        super(name, age, sex, phoneNumber, className, classCode);
        this.studentCode = studentCode;
    }

    public Student(String name, String age, String sex, String studentCode) {
        super(name,age,sex);
        this.studentCode = studentCode;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode='" + studentCode + '\'' +
                super.getName()+ " " + super.getAge()+" "+super.getSex()+
                '}';
    }
}
