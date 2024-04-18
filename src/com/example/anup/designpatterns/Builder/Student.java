package com.example.anup.designpatterns.Builder;

public class Student {
    private  int Age;
    private String FName;
    private String LName;
    private String gender;
    private double psp;
    private double weight;

   private Student(Builder builder) {
       this.Age = builder.getAge();
       this.FName = builder.getFName();
       this.LName = builder.getLName();
       this.gender = builder.getGender();
       this.psp = builder.getPsp();
       this.weight = builder.getWeight();

   }
   public static Builder CreateBuilder() {
       return new Builder();
   }

    public static class Builder {
        private  int Age;
        private String FName;
        private String LName;
        private String gender;
        private double psp;
        private double weight;
        public Student build() {
            return new Student(this);
        }

        public Builder setAge(int age) {
            Age = age;
            return this;
        }

        public Builder setFName(String FName) {
            FName = FName;
            return this;
        }

        public Builder setLName(String LName) {
            LName = LName;
            return this;
        }

        public Builder setGender(String gender) {
            gender = gender;
            return this;
        }

        public Builder setPsp(double psp) {
            psp = psp;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public int getAge() {
            return Age;
        }

        public String getFName() {
            return FName;
        }

        public String getLName() {
            return LName;
        }

        public String getGender() {
            return gender;
        }

        public double getPsp() {
            return psp;
        }

        public double getWeight() {
            return weight;
        }
    }

}
