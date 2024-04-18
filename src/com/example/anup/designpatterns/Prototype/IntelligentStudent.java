package com.example.anup.designpatterns.Prototype;

public class IntelligentStudent extends Student {
    private int iq;

    public IntelligentStudent() {

    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public IntelligentStudent(IntelligentStudent intelligentStudent) {
        super(intelligentStudent);
        this.iq = intelligentStudent.iq;
    }
    @Override
    public IntelligentStudent Clone() {
        return new IntelligentStudent(this);
    }

}
