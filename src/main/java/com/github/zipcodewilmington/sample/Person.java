package com.github.zipcodewilmington.sample;

public class Person implements PersonInterface {

    private String fName;
    private String lName;
    private Integer age;

    public Person(){
//        this.fName = null;
//        this.lName = null;
//        this.age = null;
    }

    public Person(String fName, String lName, Integer age){
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }
    @Override
    public String getFirstName() {
        return fName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.fName = firstName;
    }

    @Override
    public String getLastName() {
        return lName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lName = lastName;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }
}