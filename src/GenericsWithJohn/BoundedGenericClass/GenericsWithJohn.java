package GenericsWithJohn.BoundedGenericClass;

public class GenericsWithJohn {
    public static void main(String[] args) {
        // won't work here now: Printer<Integer> integerPrinter = new Printer<>(23);
        // because Printer is now a bounded generic that extends the Animal class
        // e.g. every thing to print should now be an Animal (not an Integer)

        Printer<Cat> catPrinter = new Printer<>(new Cat());
        catPrinter.print();

        Printer<Dog> dogPrinter = new Printer<>(new Dog());
        dogPrinter.print();
    }
}
