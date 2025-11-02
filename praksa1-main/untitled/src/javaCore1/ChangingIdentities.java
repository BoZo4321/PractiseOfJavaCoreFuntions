package javaCore1;

class Person {
    String name;
    int age;

    public Person(String ime, int godina) {
        this.name = ime;
        this.age = godina;
    }

    public Person() {
    }
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        Person p3 = new Person();

        p3.name = p1.name;
        p1.name = p2.name;
        p2.name = p3.name;

        p3.age = p1.age;
        p1.age = p2.age;
        p2.age = p3.age;
    }
}

public class ChangingIdentities {
    public static void main(String[] args) {
        Person p1 = new Person("marko", 25);
        Person p2 = new Person("luka", 33);

        System.out.println("Person1 " + p1.name + ", godina " + p1.age);
        System.out.println("Person2 " + p2.name + ", godina " + p2.age);
        System.out.println();

        MakingChanges.changeIdentities(p1, p2);

        System.out.println("Person1 " + p1.name + ", godina " + p1.age);
        System.out.println("Person2 " + p2.name + ", godina " + p2.age);
    }
}
