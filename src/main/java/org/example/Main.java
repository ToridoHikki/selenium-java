package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Student> classA = new ArrayList<Student>();
        

        for (int i = 0; i < 10; i++) {
            classA.add(new Student(randomName(), randomAge(), randomScore()));

        }

        for (int i =0 ; i < classA.size(); i++) {
            System.out.println("Student " + (i+1) + ":");
            classA.get(i).info();
            classA.get(i).rank();
            System.out.println(" ----------");
        }
//        classA.stream().forEach(Student::info);

        System.out.println(" STUDENT Has SCORE >= 9.0 ------");
      classA.stream()
              .filter(student -> student.getAverageScore() >= 9.0)
               .forEach(Student::info);

        classA.stream()
                .filter(student -> student.getAge() > 20)
                .map(Student::getName)
                .forEach(System.out::println);

        System.out.println("BEST STUDENT ------");
        classA.stream()
                .max(Comparator.comparing(Student::getAverageScore))
                .get()
                .info();
//        String sentence = scanner.nextLine();
//        upperFirstCase(sentence);
        
    }

    //random score from 1 to 10 in double
    //random age from 18 to 25 in int
    //random name from array {"Huong", "Anh, "Mai", "Nhu", "Thao", "Hanh",Thanh", "Thuy", "Nguyen", "Tien"}
    public static String randomName () {
        String[] names = {"Huong", "Anh", "Mai", "Nhu", "Thao", "Hanh", "Thanh", "Thuy", "Nguyen", "Tien"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }
    public static double randomScore () {
        Random random = new Random();
        double score = 1.0 + 9.0 * random.nextDouble();
        return  Math.round(score*10.0)/10.0;
    }

    public static int randomAge () {
        Random random = new Random();
        return random.nextInt(8) + 18;
    }

//    public static void upperFirstCase (String sentence ) {
//        String[] words = sentence.split(" ");
//        StringBuilder result = new StringBuilder();
//
//        ///  nhu     ngao
//        for (String word : words) {
//            console.log("current word: " + word);
//            if (word.length() > 0) {
//                /// nhu
//                char firstChar = Character.toUpperCase(word.charAt(0));
//                /// Ngao
//                result
//                        .append(firstChar)
//                        .append(word.substring(1))
//                        .append(" ");
//            }
//        }
//
//        System.out.println(result.toString().trim());
//
//    }
    //Thay đổi ký tự đặc biệt trong 1 chuỗi cho trước: thay ký tự @  bằng ký tự _
    public static String changeSpecialCharacter (String str) {
       return str.replace("@", "_");
    }

}

class console {
    public static void log(String message) {
        System.out.println(message);
    }
}





