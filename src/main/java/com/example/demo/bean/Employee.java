package com.example.demo.bean;

public class Employee {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String tel;
    private String email;
//    private Integer depart_id;
    private Department depart;

    public Employee() {
    }

    public Employee(String name, String gender, Integer age, String tel, String email, Department depart) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.tel = tel;
        this.email = email;
//        this.depart_id = d_id;
        this.depart = depart;
    }

//    public int getDepart_id() {
//        return depart_id;
//    }
//
//    public void setDepart_id(int depart_id) {
//        this.depart_id = depart_id;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepart() {
        return depart;
    }

    public void setDepart(Department depart) {
        this.depart = depart;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", depart=" + depart +
                '}';
    }
}
