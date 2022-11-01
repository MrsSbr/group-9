package AnimalConstruction;

public abstract class Animal {
    public int age;
    public String name;

    public Animal (int age, String name){
        this.age = age;
        this.name = name;
    }

    public abstract String getName();
    public abstract int getAge();
}



