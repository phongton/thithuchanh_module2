package controller;

import model.MyClass;
import model.NotFoundStudentException;
import reponsitory.Repositories;
import service.Service;
import view.ViewClass;

import java.util.List;

public class ControllerClass {
    public static void main(String[] args) throws NotFoundStudentException {
        ViewClass viewClass = new ViewClass();
        int choice;
        boolean check;
        List<MyClass> myClasses;
        Service service = new Service();
        Repositories repo = new Repositories();
        while(true){
            choice = viewClass.displayMenu();
            switch (choice){
                case 1:
                     viewClass.addNewStudent();
                     break;
                case 2:
                    String id = viewClass.deleteStudent();
                    myClasses = service.SearchByCode(id);
                    repo.DeleteStudent((MyClass) myClasses);
                    break;
                case 3:
                    myClasses = service.getAll();
                    viewClass.viewStudent(myClasses);
                    break;
                case 4:
                    break;
                case 5:
                    return;
            }


        }
    }

}
