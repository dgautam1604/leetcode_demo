package com.deep.leetcode_demo.javaEight;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class lambdaSort {
    public static void main(String[] args) {
        //comparator to sort a list of strings by length.
        List<String> names= Arrays.asList("John","Amy","Rajesh");
        names.sort((s1,s2)->Integer.compare(s1.length(),s2.length()));
        System.out.println(names);


        //stream and filter
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evenNum=numbers.stream().filter(n->n%2==0).toList();
        System.out.println(evenNum);

        //map
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .toList();
        System.out.println(squares);

        List<String> uppercased = names.stream()
                .map(String::toUpperCase) //equivalent to .map(s -> s.toUpperCase())and written as Class::functionName
                .toList();
        System.out.println(uppercased);

        //optional
        Optional<String> first=names.stream().filter(n->n.startsWith("A")).findFirst();
        System.out.println(first);
        first.ifPresent(System.out::println);//method referencing

        String value = null;

        String result = Optional.ofNullable(value)
                .orElse("Default Value");

        System.out.println(result); // Default Value

        //grouping by
        Map<Integer, List<String>> groupedByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);

        Map<Integer, Long> groupedByLengthWithCount = names.stream()
                .collect(Collectors.groupingBy(String::length,Collectors.counting()));

        System.out.println(groupedByLengthWithCount);

        //It groupingBy + mapping
//        Map<String, List<String>> namesByDepartment = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,
//                        Collectors.mapping(Employee::getName, Collectors.toList())

        //Reduce function for sum
        int sum = numbers.stream().reduce(0, (a, b) -> a + b); //reduce(identity, accumulator) where identity is initalSum so even if stream is empty result is zero and not optional
        System.out.println(sum);
        Optional<Integer> sum2 = numbers.stream().reduce( (a, b) -> a + b); //reduce(BinaryOperator)
        System.out.println(sum2);
        Optional<Integer> sum3 = numbers.stream().reduce( Integer::max); // find max
        System.out.println(sum3);

        int sum4 = numbers.parallelStream()
                .reduce(0, Integer::sum); //multiple threads

        System.out.println(sum4);

        Integer sum5 = numbers.parallelStream()
                .reduce(
                        0,                         // identity
                        (subtotal, element) -> subtotal + element,  // accumulator
                        (subtotal1, subtotal2) -> subtotal1 + subtotal2 // combiner combines sum of threads
                );

        System.out.println(sum5);

    }
}
