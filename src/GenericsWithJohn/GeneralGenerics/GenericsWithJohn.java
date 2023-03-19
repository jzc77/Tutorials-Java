package GenericsWithJohn.GeneralGenerics;
// https://www.youtube.com/watch?v=K1iu1kXkVoA (Generics In Java - Full Simple Tutorial)

public class GenericsWithJohn {

    public static void main(String[] args) {
        // Using the long way to print different data types by making separate printing classes for each type
//        IntegerPrinter integerPrinter = new IntegerPrinter(23);
//        integerPrinter.print();
//
//        DoublePrinter doublePrinter = new DoublePrinter(23.22);
//        doublePrinter.print();
//
//        StringPrinter stringPrinter = new StringPrinter("2323 string");
//        stringPrinter.print();

        // Using the same generic class to print different types of data
        Printer<Integer> integerPrinter = new Printer<>(23);  // "Integer" type will be passed into "T" in Printer.java
        integerPrinter.print();

        Printer<Double> doublePrinter = new Printer<>(23.23);  // "Double" type will be passed into "T" in Printer.java
        doublePrinter.print();

        Printer<String> stringPrinter = new Printer<>("2323 string");  // "String" type will be passed into "T" in Printer.java
        stringPrinter.print();


    }

}
