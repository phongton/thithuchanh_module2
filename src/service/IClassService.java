package service;

import model.MyClass;

import java.util.List;

public interface IClassService <T extends MyClass>{
    boolean add(T t);
    boolean delete(T t);
    List<T> getAll();
    List<T> SearchByCode(String code);
}
