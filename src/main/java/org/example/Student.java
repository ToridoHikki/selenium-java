package org.example;

import java.util.Random;
import java.util.UUID;

public class Student {
    private String name;
    private int age;
    private double averageScore;
    private String id;

    public Student(String name, int age, double averageScore) {
        //random student id with prefix "TVN-AK48-"
        Random random = new Random();
        int randomNumber = 1000+random.nextInt(9000);
        this.id = "TVN-AK48-" + randomNumber;
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getAverageScore() {
        return averageScore;
    }


    public void info() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Average Score: " + averageScore);
    }

    public void rank() {
        if (averageScore >= 9.0) {
            System.out.println("Rank: Excellent");
        } else if (averageScore >= 8.0) {
            System.out.println("Rank: Good");
        } else if (averageScore >= 6.5) {
            System.out.println("Rank: Avagare");
        } else {
            System.out.println("Rank: Poor");
        }
    }



}
