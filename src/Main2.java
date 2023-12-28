import java.util.*;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 23, 45, 6, 7, 8, 8, 9, 9, 87, 6, 65);

        List<Integer> list = integers.stream().filter(i -> i == 0).toList();


        Stream<Integer> stream = integers.stream();
//
//        List<Integer> list1 = stream.filter(i -> i == 1).toList();
//        System.out.println("<<<");
//        list1.stream().forEach(System.out::println);
//        System.out.println(">>>");


        Stream<Integer> test = Stream.of(1, 23, 4, 5, 5, 454, 3, 45, 24, 534, 5, 346, 42, 23, 32, 5, 345, 563, 46, 34, 5);

        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 23, 4, 5, 6, 7, 7, 6});

        Stream<Object> build = Stream.builder().add(1).add(2).add(3).build();


        User.builder().setAge(18).setName("Test").setLastName("Test").getAge();


        //test1();

        test2();

    }


    private static long test() {
        Stream<Integer> stream = List.of(1, 23, 0, 0, 0, 0, 0, 0, 0, 40000000, 5, 6, 7, 53, 54, 36, 4, 756, 8, 798, 678).parallelStream();
        //long c =
        Optional<String> reduce = stream
                //.peek(System.out::println)
                .skip(5).limit(10).distinct()//.mapToInt(x ->x*2)
                .map(x -> x + "")
                //.sorted((o1, o2) -> o2.length()-o1.length())
                //.peek(System.out::println)
                .filter(i -> !i.equals("0"))
                //.count();
                //.findFirst()
                //.findAny()
                //.collect(Collectors.toSet())
                //.allMatch(x -> x.equals("0"))
                //.noneMatch(x-> x.equals("0"))
                //.anyMatch(x -> x.equals("0"))
                //.forEachOrdered(System.out::println);
                //.forEach(System.out::println)
                //.toArray()
                .reduce((s, s2) -> s + s2);

        System.out.println(reduce.get());


        return 0;
    }

    private static void test1() {
        System.out.println(test() + "<<<<<<<<<!!!");
    }

    private static void test2() {
        // String s = test3();

        Optional<String> optional = Optional.ofNullable(test3());


        //
        optional.ifPresentOrElse(s -> {
            System.out.println(s + "<<");
        }, () -> {
            new Exception();
        });


        //optional.orElseThrow(() -> new ClassCastException());

        optional.ifPresent(x -> {
            System.out.println("<<<");
            boolean equals = x.equals("1");
            System.out.println(equals);

        });
        optional.orElse("$$$$");

        optional.orElseGet(() -> {
            return "dasfg";
        });

        //optional.orElseThrow();


//        if (s == null) {
//            System.out.println("s is null be carefull");
//        } else {
//            System.out.println(s.equals("1"));
//        }

    }


    private static String test3() {
        return null;
    }

    private static void test4() {
        List<Integer> integers = List.of(1, 2, 34, 5);
        Set<Integer> integers1 = Set.of(1, 2, 4, 5, 6);
        Set<Integer> integers2 = new HashSet<>();
        integers2.add(1);
        integers2.add(2);
        integers2.add(3);
        integers2.add(4);
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);


        User user = new User(List.of(integers1, integers2, treeSet), List.of());

        user.getRates().stream().forEach(i->{
            i.forEach(s -> System.out.println(s));
        });
    }

    public static void main111() {

        User user = new User();

        Optional<String> user1 = Optional.of(user.getName());

        user1.ifPresentOrElse(user2 -> System.out.println(user2), () -> System.out.println("DEFAULT"));

    }


}
