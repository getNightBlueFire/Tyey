import api.Name;
import api.Response;
import api.Result;
import com.google.gson.Gson;
import example.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        //Date date1 = new Date();
//        Test<Integer> t = (a, b) -> a+b;
//
//        t.minus(10,10);
//
//        t = (a, b) -> a-b;
//
//        t.minus(10,10);
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//
//        //System.out.println(dateFormat.format(date1).toString());
//
//        LocalDate now = LocalDate.of(2024, 1, 1);
//        LocalTime now2 = LocalTime.now();
//
//        System.out.println(now.getDayOfWeek());
//
//        LocalDate parse = LocalDate.parse("11/-/11/23", DateTimeFormatter.ofPattern("dd/-/MM/yy"));
//        System.out.println(parse.getDayOfWeek().toString());
//
//        DayOfWeek dayOfWeek = now.getDayOfWeek();
//        System.out.println(dayOfWeek.toString());
//
//
//        Supplier<Response> supplier = Main::getUser;
//        supplier = () -> Main.getUser();
//        Response response0 = supplier.get();
//        var results = response0.getResults();
//
//        Predicate<Name> test = (Name x) -> x.getFirst().startsWith("A");
//        Stream<Result> stream = results.stream();
//
//
////        Stream<Result> f = stream.filter(result -> test.test(result.getName()))
////                .filter((Result x) -> {
////                    boolean x1 = x.getGender().startsWith("f");
////                    //
////                    //
////
////                    //
////                    return x1;
////                });
//
//
//
////        List<User> list = stream
////                .map(x -> new User(x.getGender(), x.getDob().getAge(), x.getName().getTitle())).sorted((o1, o2) -> 0)
////                .filter(result -> test.test(result.getName()))
////                .distinct()
////                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
////                .toList();
//
//
//
//        List<Integer> integers = new ArrayList<>();
//
//
//        Predicate<Integer> testOdd = x -> x%2==0;
//
//        integers.stream().filter(testOdd).forEach(System.out::println);
//        for (Integer integer : integers) {
//            System.out.println(integer);
//        }
//        Integer t1 = 10;
//
//
//        System.out.println(testOdd.test(t1));
//
//
////        System.out.println(list.size());
////
////        list.forEach(x -> System.out.println(x));
////        list.forEach(System.out::println);
////
////        for (User s : list) {
////            System.out.println(s.getName() + "   " + s.getGender());
////            if (s.getName().startsWith("A")) {
////
////
////            }
////        }
//
//
//        //Test<Integer> t = (x, y) -> new Random().nextInt(x, y);
//
//        Supplier<Integer> integerSupplier = () -> new Random().nextInt(10, 20);
//
//        Integer i1 = integerSupplier.get();
//        System.out.println(i1 + "<<<<");
//
//
//        int a = t.minus(10, 20);
//        System.out.println(a);
//
//
//        Function<Integer, String> function = (x) -> x.toString() + "10";
//
//        String apply = function.apply(10);
//        System.out.println();
//
        Response user = getUser();

        List<Result> results = user.getResults();

        results.forEach(r-> System.out.println(r.getName().getFirst()));

    }

    static String getDate(int year, int day, int month) {
        return LocalDate.of(year, day, month).getDayOfWeek().toString();
    }

    static void getTest() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();
        System.out.println(getDate(i, i1, i2));
    }


    public static Response getUser() {
        String uri = "https://randomuser.me/api/";
        //TODO make different methods
        uri += "?results=200";
        //String uri = "?gender=female";

        //String uri = "?format=csv";
        //JSON (default), PrettyJSON or pretty, CSV, YAML, XML
        //String uri = "?nat=gb(,fi)"
        //v1.3: AU, BR, CA, CH, DE, DK, ES, FI, FR, GB, IE, IR, NO, NL, NZ, TR, US
        //String uri = "?results=5&inc=name,gender,nat& noinfo";
        //String uri = "?inc=gender(,name)";
        //String uri = "?exc=login";
        String get = "GET";
        URL url;
        HttpURLConnection con;
        BufferedReader in;
        StringBuilder content = new StringBuilder();
        Gson gson = new Gson();
        Response response;
        try {
            url = new URL(uri);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(get);
            con.getResponseCode();
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            response = gson.fromJson(content.toString(), Response.class);
            in.close();
            con.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @FunctionalInterface
    interface Test<T1> {
        int minus(T1 a, T1 b);
    }

}
