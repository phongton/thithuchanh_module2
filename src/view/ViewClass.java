package view;

import common.CheckRegex;
import common.ExceptionHandler;
import model.MyClass;
import model.NotFoundStudentException;
import model.Student;
import reponsitory.Repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ViewClass {
    Scanner scanner = new Scanner(System.in);
    ExceptionHandler exception = new ExceptionHandler();
    int choice;
    String dobStr = null;
    Repositories repo = new Repositories();

    public int displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add new student");
        System.out.println("2. Delete student");
        System.out.println("3. View student list");
        System.out.println("4. Search student");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        choice = ExceptionHandler.checkParseInteger();
        return choice;
    }

    public MyClass addNewStudent() throws NotFoundStudentException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student information:");
        System.out.print("Name: ");
        String name = CheckRegex.checkRegexName();

        System.out.print("Date of Birth (dd/MM/yyyy): ");
        String dobStr = scanner.nextLine();

        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Class Code: ");
        String classCode = scanner.nextLine();

        if (!phoneNumber.matches("(090|091)\\d{7}")) {
            System.out.println("Phone number must start with 090 or 091 and have 10 digits.");
        }
        Student student = new Student(name,dobStr,gender,classCode);
        repo.add(student);

        return student;
    }
    public void messageCheck(boolean check) {
        if (check) {
            System.out.println("Tác vụ thành công ");
        } else {
            System.out.println("Tác vụ thất bại ");
        }
    }
    public void viewStudent(List<MyClass> myClasses){
        System.out.println("Danh sách sản phẩm hiện có là :");
        for (MyClass myClass : myClasses){
            System.out.println(myClass.toString());
        }
    }
    public String deleteStudent(){
        System.out.print("Enter student code to delete: ");
        String code = scanner.nextLine();
        return code;
    }


}
