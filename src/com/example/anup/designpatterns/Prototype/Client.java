package com.example.anup.designpatterns.Prototype;

public class Client {
    public  static void FillRegistry(StudentRegistry studentRegistry)
    {
        Student student = new Student();
        student.setAge(20);
        student.setName("Anup");
        student.setBatch("B1");
        student.setAverageBatchPsp(8.5);
        student.setStudentPsp(9.0);
        studentRegistry.RegisterStudent("Anup",student);

        IntelligentStudent intelligentStudent = new IntelligentStudent();
        intelligentStudent.setAge(200);
        intelligentStudent.setName("Devendra");
        intelligentStudent.setBatch("B1");
        intelligentStudent.setAverageBatchPsp(78.5);
        intelligentStudent.setStudentPsp(10.0);
        intelligentStudent.setIq(1200);
        studentRegistry.RegisterStudent("Devendra",intelligentStudent);
    }
    public static void main(String[] args) {
        StudentRegistry studentRegistry = new StudentRegistry();
        FillRegistry(studentRegistry);
        Student student = studentRegistry.getStudent("Anup");
        System.out.println(student);
        IntelligentStudent intelligentStudent = (IntelligentStudent) studentRegistry.getStudent("Devendra");
        System.out.println(intelligentStudent);
    }
}
