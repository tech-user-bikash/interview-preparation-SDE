package com.java.java8;

import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPITest {
    public static void main(String[] args) {
        EMP e1 = new EMP(1000, "Head", "IT");
        EMP e2 = new EMP(1200, "James", "EEE");
        EMP e3 = new EMP(1400, "Kailash", "CS");
        EMP e4 = new EMP(1500, "Madhav", "IT");
        EMP e5 = new EMP(1100, "Kiran", "IT");
        EMP e6 = new EMP(1130, "Kiran", "EEE");
        EMP e7 = new EMP(1910, "Laden", "CS");
        EMP e8 = new EMP(1730, "Madman", "EEE");
        EMP e9 = new EMP(1930, "Lucky", "CS");

        List<EMP> empList = List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9);

//        var collectedEmp = empList.stream()
//                .collect(Collectors
//                        .toMap(
//                                EMP::getDept,
//                                Function.identity(),
//                                BinaryOperator.maxBy(Comparator.comparingInt(EMP::getSal))))
//                ;
        // Nth Highest Salary
        var collectedEmp = empList.stream().collect(
          Collectors.groupingBy(
                  EMP::getDept,
                  Collectors.collectingAndThen(
                          Collectors.toList(),
                          list->list.stream()
                                  .sorted(Comparator.comparingInt(EMP::getSal).reversed())
                                  .skip(2)
                                  .findFirst()
                  )));

        collectedEmp.forEach((k, v) -> {
            System.out.println(k + ":"+v);
//            v.forEach(e -> {
//                System.out.println("    " + e.getName());
//                System.out.println("    " + e.getSal());
//                System.out.println();
//            });
        });
    }

    @Data
    static class EMP {
        private int sal;
        private String name;
        private String dept;

        public EMP(int _sal, String _name, String _dept) {
            this.sal = _sal;
            this.name = _name;
            this.dept = _dept;
        }
    }
}


