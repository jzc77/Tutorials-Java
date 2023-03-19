package GenericsWithJohn.BoundedGenericClass;

public class Printer<T extends Animal> {  // This is called a bounded generic. "T" is now some type of Animal.
    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        thingToPrint.eat();  // can use eat() because Printer class extends Animal class
        System.out.println(thingToPrint);
    }
}
