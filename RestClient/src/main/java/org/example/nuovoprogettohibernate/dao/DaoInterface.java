package org.example.nuovoprogettohibernate.dao;


import java.util.List;

public interface DaoInterface <T>{

    public List<T> retrieve();
    public void create(T object);
    public void delete(T object);
    public void updateTwoAttributesInId1(String n, String s);
    public List<T> retrieveByAnAttribute(String n);
    public T retrieveForId(int id);
    public void deleteByAttribute (String a);

}
