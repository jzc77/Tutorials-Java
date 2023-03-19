package GenericsWithJohn.GenericMethods;

import GenericsWithJohn.BoundedGenericClass.Animal;
import GenericsWithJohn.BoundedGenericClass.Cat;

import java.util.ArrayList;
import java.util.List;

public class GenericsWithJohn {

//    public static <T> void shout(T thingToShout) {  // Tell Java T is a generic type by adding <T> in the method signature (before the return type)
//        System.out.println(thingToShout + "!!!!");
//    }

//public static <T, V> void shout(T thingToShout, V otherThingToShout) {  // Multiple different generic types
//    System.out.println(thingToShout + "!!!!");
//    System.out.println(otherThingToShout + "!!!!");
//}

//    public static <T, V> T shout(T thingToShout, V otherThingToShout) {  // Return one of the multiple different generic types
//        System.out.println(thingToShout + "!!!!");
//        System.out.println(otherThingToShout + "!!!!");
//        return thingToShout;  // Return thing of type T
//    }

//    private static void printList(List<Object> myList) {  // Taking in a list that can contain any types
//        System.out.println(myList);
//    }

    private static void printList(List<? extends Animal> myList) {  // Taking in a list that can contain any types
        System.out.println(myList);
    }

    public static void main(String[] args) {
//        shout("John");
//        shout(57);
//        shout(new Cat());

//        shout("John", 37);

//        shout("John", 37);

//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(3);
//        printList(integerList);  // Error! Because a list of integers is not a subclass of a list of objects. Need to use a wild card.

        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        //printList(integerList);  // [3] if unbounded, error if bounded by Animal class

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        printList(catList);  // (Works, but I did not implement Cat() class fully)

    }
}
