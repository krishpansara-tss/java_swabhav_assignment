import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment {
    public static void main(String[] args) {
        List<String> students = Arrays.asList(
                "Amit Tiwari",
                "Rahul Sharma",
                "Sneha Patil",
                "Ankit Verma",
                "Ravi Kumar",
                "Amit Tiwari",
                "Pooja Mehta",
                "Neha Singh",
                "Krish Kumar"
        );

//        System.out.println(students);
        System.out.println("\n1.PRint student");
        students.stream().forEach(System.out::println);

        System.out.println("\n2.total student");
        long studentCount = students.stream().count();
        System.out.println(studentCount);

        System.out.println("\n3.new list having unique student");
        List<String> uniqueStudents = students.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueStudents);

        System.out.println("\n4.al[habetical order");
        students.stream().sorted().forEach(System.out::println);

        System.out.println("\n4.reverse alpabetical order");
        students.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("\nfisrts a");
        students.stream().filter((name) -> name.charAt(0) == 'a').forEach(System.out::println);

        System.out.println("\nname length > 10");
        students.stream().filter((name) -> name.length() > 10).forEach(System.out::println);

        System.out.println("\nupercase + list");
        List<String> upperCase = students.stream().map((name) -> name.toUpperCase()).collect(Collectors.toList());
        System.out.println(upperCase);

        System.out.println("\nlowercase + list");
        List<String> lowerCase = students.stream().map((name)-> name.toLowerCase()).collect(Collectors.toList());
        System.out.println(lowerCase);

        System.out.println("\nextraxct firstname + list");
        List<String> firstName = students.stream().map((name) -> name.split(" ")[0]).collect(Collectors.toList());
        System.out.println(firstName);

        System.out.println("total unique count");
        long uniqueCount = students.stream().distinct().count();
        System.out.println(uniqueCount);

        System.out.println("\nlongest student name");
        Optional<String> longest = students.stream().max(Comparator.comparing(String::length));
        System.out.println(longest);

        System.out.println("\nshortest");
        Optional<String> sortest = students.stream().min(Comparator.comparing(String::length));
        System.out.println(sortest);

        System.out.println("Total chars among all students");
        int sum = students.stream().mapToInt(String::length).sum();
        System.out.println("sum of all the chars" + sum);

        System.out.println("\nfind avg lenght");
        double avgLength = students.stream().mapToDouble(String::length).sum() / students.stream().count();
        System.out.println("Avg len" + avgLength);

        System.out.println("\n how many time each student");
        Map<String, Long> mapStudent = students.stream().collect(Collectors.groupingBy(
                name -> name,
                Collectors.counting()
        ));
        System.out.println(mapStudent);

        System.out.println("\nFind all duplicate student names.");
        List<String> dublicateName = students.stream().collect(Collectors.groupingBy(
                name -> name,
                Collectors.counting()
        )).entrySet().stream().filter((entry) -> entry.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println(dublicateName);


        System.out.println("\nGroup students by the first letter of their first name.");
        Map<Character, List<String>> grpByFirstName = students.stream().collect(Collectors.groupingBy(
                name->name.charAt(0)
        ));
        System.out.println(grpByFirstName);

        System.out.println("Create a map where:\n" +
                "Key = First Name\n" +
                "Value = Last Name");
        Map<String, String> keyVal =
        students.stream().map((name) -> name.split(" ")).collect(Collectors.toMap(
                parts -> parts[0],
                parts -> parts[1],
                (oldVal, newVal) -> oldVal
        ));
        System.out.println(keyVal);

        System.out.println("Partition students into two groups:\n" +
                "Names having more than 10 characters\n" +
                "Names having 10 or fewer characters");

        Map<Boolean, List<String>> partitionBy10 = students.stream().collect(Collectors.partitioningBy((name) -> name.length() > 10));
        System.out.println(partitionBy10);

        System.out.println("\nCreate a comma-separated string of all unique student names sorted alphabetically.");
        String allName = students.stream().distinct().sorted().reduce("",(all, name) -> all+name+", ");
        System.out.println(allName);

        System.out.println("\nFind the student name containing the highest number of vowels");
        Optional<String> longestName = students.stream().max(Comparator.comparingInt((name)-> (int)name.toLowerCase().chars().filter(c -> "aeiou".indexOf(c) != -1).count()));
        System.out.println(longestName);

        System.out.println("\nFind the second longest unique student name.");
        Optional<String> secondLargest = students.stream().distinct().sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst();
        System.out.println(secondLargest);

        System.out.println("\nFind the frequency of each character used across all student names (excluding spaces).");
        Map<Character, Long> eachChar = students.stream().flatMap((name)->name.replace(" ","").toLowerCase().chars().mapToObj(c -> (char)c)).collect(Collectors.groupingBy(
                c -> c,
                Collectors.counting()
        ));
        System.out.println(eachChar);

        System.out.println("\nUsing Stream API and reduce(), calculate the total number of characters present in all names.");
        Integer charPresent = students.stream().map((name) -> name.length() - 1).reduce(0, Integer::sum);
        System.out.println(charPresent);

        System.out.println("Create a Map<Integer, List<String>> where the key is the length of the student name and the value is the list of names having that length.");
        Map<Integer, List<String>> length_list = students.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(length_list);

        System.out.println("\nFind all names whose first and last names start with the same letter");
        students.stream().filter((name) -> name.split(" ")[0].charAt(0) == name.split(" ")[1].charAt(0)).forEach(System.out::println);

        System.out.println("\nIdentify the most frequently occurring student name.");
        Optional<String> mostFrequent = students.stream().collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
        System.out.println(mostFrequent);

        System.out.println("\nCreate a custom comparator and sort students based on:\n" +
                "1. Length of name\n" +
                "2. Alphabetical order if lengths are equal"
        );
        List<String> sorted = students.stream().sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo)).toList();

        System.out.println(sorted);

        System.out.println("\nWithout using loops, print all unique first names in sorted order.");
        students.stream().distinct().map((name) -> name.split(" ")[0]).sorted().forEach(System.out::println);


    }

}
