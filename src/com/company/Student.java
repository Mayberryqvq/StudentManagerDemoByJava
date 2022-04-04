package com.company;

public class Student {
    private String num;
    private String age;
    private String name;
    private String address;

    public Student(){};


    public Student(String age,String num, String name, String address){
        this.age = age;
        this.num = num;
        this.name = name;
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }
}
