package service;

import model.MyClass;
import reponsitory.Repositories;

import java.util.List;

public class Service implements IClassService{
    Repositories repositories = new Repositories();
    @Override
    public boolean add(MyClass myClass) {
         repositories.add(myClass);
        return true;
    }

    @Override
    public boolean delete(MyClass myClass) {
        repositories.DeleteStudent(myClass);
        return false;
    }

    @Override
    public List<MyClass> getAll() {
        return repositories.getAll();
    }

    @Override
    public List<MyClass> SearchByCode(String code) {
        List<MyClass> list = getAll();
        for (MyClass myClass: list){
            if (myClass.getClassCode().equals(code)){
                return myClass;

            }
        }
        return null;
    }
}
