package com.example.anup.designpatterns.Prototype;
import java.util.HashMap;
import java.util.Map;
public class StudentRegistry {
    private Map<String,Student> mp=new HashMap<>();

    void RegisterStudent(String name, Student student) {
        mp.put(name,student);
    }
    Student getStudent(String name) {
        return mp.get(name).Clone();
    }
}
