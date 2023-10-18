import java.util.Scanner;

public class WeightCalculator{
    public static void main(String[] args){ //Main Class
        Scanner sc = new Scanner(System.in); 
        System.out.println("How much weight are you in pounds?");
        double weight_pounds = sc.nextInt(); 
        double weight_kgs = weight_To_Pounds(weight_pounds);
        Person Aran = new Person("Aran", 19, "Male", weight_kgs); //Objects - Objects access the constructor
        System.out.printf("Your weight in kgs is %.2f %s", Aran.weight , "kgs");
        sc.close();
    }
    public static double weight_To_Pounds(double weight_pounds){ //Method
        double conversion_kgs_to_pounds =  0.45359237; 
        double weight_kgs = weight_pounds*conversion_kgs_to_pounds;
        return weight_kgs; 
    }

}

class Person{
    public String name;
    private int age;
    public String gender;
    public double weight;
    public Person(String name, int age, String gender, double weight){ //Constructor 
        this.name = name;
        this.age = age;
        this.gender = gender; 
        this.weight = weight; 
    }
}