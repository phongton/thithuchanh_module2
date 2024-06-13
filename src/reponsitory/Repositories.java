package reponsitory;

import model.MyClass;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repositories {
    private static final String URL_STUDENT = "D:\\benh_an\\thithuchanh_module2\\src\\reponsitory\\data\\students.csv";
    List<MyClass> classList = new ArrayList<>();

    public void add(MyClass myClass) {
        classList.add(myClass);
        writeFile(myClass, true);
    }

    private void writeFile(List<MyClass> myClass, boolean append) {
        File file = new File(URL_STUDENT);
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            if (myClass instanceof Student) {
                bufferedWriter.write(toString((Student) myClass));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Lỗi ghi File!");
        } catch (Exception e) {
            System.out.println("lỗi ghi file");
        }
    }
    public List<MyClass> getAll() {
        List<MyClass> list = new ArrayList<>();
        File file = new File(URL_STUDENT);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] t = line.split(",");
                if (t.length>=4){
                    list.add(new Student(t[0],t[1],t[2],t[3]));

                }


            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thất File");
        } catch (IOException e) {
            System.out.println("Lỗi đọc dữ liệu File");
        }
        return list;
    }
    public void DeleteStudent(MyClass myClass){
        List<MyClass> myClasses =getAll();
        for (MyClass myClass1:myClass) {
            if (myClass1.getClassCode().equals(myClass.getClassCode())) {
                myClasses.remove(myClass1);
                break;
            }
        }
        for (MyClass myClass1:myClasses) {
            writeFile(myClass1, false);
        }

    }

    private String toString(Student student) {
        return student.getStudentCode() + "," + student.getName() + "," + student.getAge() + "," + student.getSex();
    }
}
