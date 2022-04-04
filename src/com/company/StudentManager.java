package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public StudentManager() {
    }

    private ArrayList<Student> array = new ArrayList<>();

    //展示主界面
    public void show() {
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addStudent(array);
                case 2 -> removeStudent(array);
                case 3 -> updateStudent(array);
                case 4 -> showAllStudent(array);
                case 5 -> {
                    System.out.println("谢谢使用");
                    System.exit(0);
                }
                default -> System.out.println("你输入的数字有误请重新输入");
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        String num;
        while (true) {
            System.out.println("请输入学生的学号");
            num = sc.nextLine();
            boolean flag = numExistsOrNot(array, num);
            if (flag) {
                System.out.println("该学号已存在，请重新输入");
            }else {
                break;
            }
        }
        System.out.println("请输入学生的年龄");
        String age = sc.nextLine();
        System.out.println("请输入学生的姓名");
        String name = sc.nextLine();
        System.out.println("请输入学生的居住地");
        String address = sc.nextLine();
        Student s = new Student();
        s.setNum(num);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        array.add(s);
        System.out.println("添加学生成功！");

    }

    //删除学生
    public static void removeStudent(ArrayList<Student> array) {
        System.out.println("请输入需要移除的学生的学号：");
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int index = -1;
        for (int j = 0; j < array.size(); j++) {
            Student student = array.get(j);
            if (student.getNum().equals(num)) {
                index = j;
                break;
            }
        }
        if (index == -1) {
            System.out.println("输入学号有误，请重新输入！");
        } else {
            array.remove(index);
            System.out.println("删除学生成功！");
        }

    }

    //修改学生
    public static void updateStudent(ArrayList<Student> array) {
        System.out.println("请输入需要修改的学生的学号：");
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        System.out.println("请输入新学生的学号");
        String newNum = sc.nextLine();
        System.out.println("请输入新学生的姓名");
        String name = sc.nextLine();
        System.out.println("请输入新学生的年龄");
        String age = sc.nextLine();
        System.out.println("请输入新学生的居住地");
        String address = sc.nextLine();
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getNum().equals(num)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("输入学号有误，请重新输入！");
        } else {
            Student student = new Student();
            student.setNum(newNum);
            student.setAddress(address);
            student.setAge(age);
            student.setName(name);
            array.set(index, student);
            System.out.println("修改学生成功！");
        }
    }

    //查看所有学生
    public static void showAllStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息在查询");
        } else {
            System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                System.out.println(s.getNum() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "\t\t" + s.getAddress());
            }
        }

    }

    public static boolean numExistsOrNot(ArrayList<Student> array, String num) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getNum().equals(num)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
