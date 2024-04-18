package com.example.anup.designpatterns.Prototype;

public class Student implements protoTypeClone<Student>{
    private int age;
    private String name;
    private String batch;
    private double averageBatchPsp;
    private double studentPsp;

    public Student(){

    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setAverageBatchPsp(double averageBatchPsp) {
        this.averageBatchPsp = averageBatchPsp;
    }

    public void setStudentPsp(double studentPsp) {
        this.studentPsp = studentPsp;
    }

    public Student(Student student) {
        this.age = student.age;
        this.name = student.name;
        this.batch = student.batch;
        this.averageBatchPsp = student.averageBatchPsp;
        this.studentPsp = student.studentPsp;
    }
    public Student Clone() {
        return new Student(this);
    }
}
