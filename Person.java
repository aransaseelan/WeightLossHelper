public class Person{
    public String name;
    private int age;
    public String gender;
    public double weight;

    public Person(String name, int age, String gender, double weight){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
    }

    public static double bmi_calculated(double weight_kgs, double height_meters){
        return weight_kgs / (height_meters * height_meters);
    }
}

class Child extends Person{
    private double previousHeight;
    private double currentHeight;

    public Child(String name, int age, String gender, double weight, double previousHeight, double currentHeight){
        super(name, age, gender, weight); /// super is used to call the constructor of the parent class (Person)
        this.previousHeight = previousHeight;
        this.currentHeight = currentHeight;
    }

    public double calculateGrowthRate(){
        return currentHeight - previousHeight;
    }
}
