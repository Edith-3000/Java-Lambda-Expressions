import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.prefs.PreferenceChangeEvent;

public class Main {
    private int field;

    public List<Hotel> getLambdaExp() {
        HotelService hotelService = new HotelService();

        int PRICE = 2000;

//        FilteringCondition myLambda = hotel -> {
//            // this.field = 420;
//            // PRICE++; // Local variables in a Lambda expression CANNOT be modified
//            return hotel.getPricePerNight() <= PRICE;
//        };

        Predicate<Hotel> myLambda = hotel -> {
            // this.field = 420;
            // PRICE++; // Local variables in a Lambda expression CANNOT be modified
            return hotel.getPricePerNight() <= PRICE;
        };

        // PRICE++;

        return hotelService.filterHotels(myLambda);
    }

    public static void main(String[] args) {
        HotelService hotelService = new HotelService();

        /* Passing functions in Java with the help of class which implements an interface ===>
         * 1. Create an interface.
         * 2. Instantiate a class that implements the interface.
         * 3. Implement the method of the interface, where the method body = function body which you wanted to pass as parameter.
         * 4. Pass an object of the concrete implementation of the interface.
         */

        // With concrete class implementation
//         List<Hotel> hotels = hotelService.filterHotels(new FilterhotelsLessThan2000());

        // With anonymous inner class
//         List<Hotel> hotels = hotelService.filterHotels(new FilteringCondition() {
//            @Override
//            public boolean test(Hotel hotel) {
//                return hotel.getPricePerNight() <= 2000;
//            }
//         });

        // With Lambda expression - NOTE: Lambdas only work with Functional Interface (An Interface having only 1 abstract method)
        List<Hotel> hotels = hotelService.filterHotels((Hotel hotel) -> {
            return hotel.getPricePerNight() <= 2000;
        });

        // In Lambda expression if you give modifier to the parameter then it's necessary to give the data type
//         List<Hotel> hotels = hotelService.filterHotels((final Hotel hotel) -> {
//             return hotel.getPricePerNight() <= 2000;
//         });

        System.out.println("List of hotels price <= 2000 " + hotels);

//        List<Hotel> fiveStars = hotelService.filterHotels(new Filter5stars());
//        System.out.println("List of 5 star hotels " + fiveStars);

        // We can store Lambda expressions as variables
//        FilteringCondition myLambda = hotel -> hotel.getPricePerNight() <= 2000;
//        List<Hotel> hotels = hotelService.filterHotels(myLambda);

        List<Integer> lst = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5));
//        Collections.sort(lst, (Integer a, Integer b) -> { return b - a; });

        // In Lambda expression it's not necessary to provide the data types
//        Collections.sort(lst, (a, b) -> { return b - a; });

        // If there's only one statement of the lambda expression body, there is no need to have curly brackets
        // and semicolon
        lst.sort((a, b) -> b - a);

        Predicate<Integer> divisibleByTwo = o -> o % 2 == 0;
//        IntPredicate divisibleByTwo = o -> o % 2 == 0;
        Predicate<Integer> divisibleByThree = o -> o % 3 == 0;
        Predicate<Integer> divisibleBySix = divisibleByTwo.and(divisibleByThree);
        System.out.println(divisibleBySix.test(48));

        Consumer<Integer> consumer = o -> System.out.print(o + " ");
//        IntConsumer consumer = o -> System.out.print(o + " ");
        lst.forEach( consumer);
        System.out.println();

        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());

//        Function<String, Integer> strToLenMap = String::length; // This is called Method Reference
        Function<String, Integer> strToLenMap = (String) -> String.length();
        Integer len = strToLenMap.apply("IRON_MAN");
        System.out.println(len);

        Function<Integer, Integer> squares = o -> o * o;
        Function<Integer, Integer> addOne = o -> o + 1;
        System.out.println(squares.andThen(addOne).apply(6));

        // Refer "Method Reference" from below link -
        // https://www.youtube.com/watch?v=0ada8fAMpVs&list=PL4WwUkr0wZURiHPaQDb-SwkY36QUAgc4p&index=3&t=4615s
    }
}
