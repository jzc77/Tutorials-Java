package GenericsWithJohn.GenericMethods;

import GenericsWithJohn.BoundedGenericClass.Cat;

public class GenericsWithJohn {

//    public static <T> void shout(T thingToShout) {  // Tell Java T is a generic type by adding <T> in the method signature (before the return type)
//        System.out.println(thingToShout + "!!!!");
//    }

//public static <T, V> void shout(T thingToShout, V otherThingToShout) {  // Multiple different generic types
//    System.out.println(thingToShout + "!!!!");
//    System.out.println(otherThingToShout + "!!!!");
//}

    public static <T, V> T shout(T thingToShout, V otherThingToShout) {  // Return one of the multiple different generic types
        System.out.println(thingToShout + "!!!!");
        System.out.println(otherThingToShout + "!!!!");
        return thingToShout;  // Return thing of type T
    }

    public static void main(String[] args) {
//        shout("John");
//        shout(57);
//        shout(new Cat());

//        shout("John", 37);

        shout("John", 37);
    }
}
