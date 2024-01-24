import java.util.*;
public class NameAge {
    public static void main(String[] args) {
// declare variables
        String name;
        int age;
        int year;
        Scanner scan = new Scanner(System.in);
//ask user for their name and read it in
        System.out.println("What is your name?");
        name = scan.nextLine();
//ask user for their age and read it in
        System.out.println("What is your age?");
        age = scan.nextInt();
// calculate year born
        year = 2023 - age;
// print output
        System.out.print("Hi " + name + "! You were born in ");
        System.out.println(year + " or " + (year-1));
    }
}