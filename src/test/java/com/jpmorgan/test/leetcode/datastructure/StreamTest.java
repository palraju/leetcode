package com.jpmorgan.test.leetcode.datastructure;

import com.jpmorgan.leetcode.model.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    void testStream () {
        List<Person> personList = new ArrayList<Person>();

        Person raju = new Person("Raju", 1, "raju.pal@yahoo.com" );
        Person prasanta = new Person("Prasanta", 2, "prsanta.pal@gmail.com" );
        Person modhu = new Person("Modhu", 3, "prsanta.pal@gmail.com" );

        personList.add(raju);
        personList.add(prasanta);
        personList.add(modhu);

        // Sorting Against Name
        List<Person> sortedList = personList.stream().sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);

        // Grouping By Email Id to find Unique Email
        Map<String, List<Person>> groupingAgainstEmail = personList.stream().collect(Collectors.groupingBy(Person::getEmailId));
        List<String> uniqueEmailWithKey = groupingAgainstEmail.entrySet().stream().map(eachEntry -> {
            System.out.println("key : " + eachEntry.getKey() + " and  Value : " + eachEntry.getValue());
            return eachEntry.getKey();
        }).sorted().collect(Collectors.toList());

        uniqueEmailWithKey.forEach(System.out::println);

        List<Person> flatMapList = groupingAgainstEmail.entrySet().stream().map(Map.Entry::getValue).flatMap(Collection::stream).collect(Collectors.toList());

        flatMapList.forEach(System.out::println);

        Predicate<Person> yahooPredicate = isYahooEmail();
        Predicate<Person> gmailPredicate = isGmailId();

        System.out.println("Predicate Test :  ------");
        List<Person> allEmail = flatMapList.stream().filter(yahooPredicate.or(gmailPredicate)).collect(Collectors.toList());
        allEmail.forEach(System.out::println);

        System.out.println("Predicate Test 1:  ------");
        List<Person> yahoolEmail = flatMapList.stream().filter(yahooPredicate.negate()).collect(Collectors.toList());
        yahoolEmail.forEach(System.out::println);
    }

    public static Predicate<Person> isYahooEmail () {
        return person -> person.getEmailId().contains("yahoo");
    }

    public static Predicate<Person> isGmailId () {
        return person -> person.getEmailId().contains("gmail");
    }

}
