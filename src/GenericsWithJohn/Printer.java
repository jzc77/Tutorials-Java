package GenericsWithJohn;

public class Printer<T> {  // T can stand for Type, but it can be whatever you want
    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
