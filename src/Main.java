import api.Response;
import api.Result;
import api.TestInfo;
import com.google.gson.Gson;
import example.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Supplier<Response> supplier = Main::getUser;
        Response response0 = supplier.get();
        var results = response0.getResults();
        Stream<Result> stream = results.stream();
        //stream.forEach(System.out::println);
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        stream.filter(x-> x.getDob().getAge()>10)
                .filter(x->x.getDob().getAge()<60)
                .map(x-> {
                    String date = x.getRegistered().getDate().split("\\.")[0];
                    LocalDateTime parse = LocalDateTime.parse(date, dtf);
                    TestInfo info = new TestInfo(x.getDob().getAge(), parse);
                    return info;
                })
                .sorted((TestInfo o1, TestInfo o2) -> {
                    if (o1.getAge() == o2.getAge()){
                        if (o1.getDate().isBefore(o2.getDate())){
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                    if(o1.getAge()>o2.getAge()){
                        return -1;
                    } else {
                        return 1;
                    }
                })
        .forEach(System.out::println);



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
    interface Test<T1>{
        void test(T1 a);
    }

    private static String revers (String s) {

        StringBuilder stringBuilder = new StringBuilder(s);

        return stringBuilder.reverse().toString();
    }
//        Stream<Integer> integerStream = Stream.of(1, 23, 5, 4, 5, 6, 7, 8);
//        Predicate<Result> predicate = x -> x.getGender().equals("female");
//        Function<Result, User> function = (x) -> new User(x.getName().getTitle()+x.getName().getFirst()+x.getName().getLast(), x.getDob().getAge(),x.getGender());
////        Function<Result, User> function = (x) -> {
////            User user = new User();
////            user.setAge(x.getDob().getAge());
////            user.setName(x.getName().getTitle()+x.getName().getFirst()+x.getName().getLast());
////            user.setGender(x.getGender());
////            return user;
////        };
//
//
//        Consumer<User> consumer = System.out::println;
//
//        List<User> collect = stream.filter(predicate).map(function).collect(Collectors.toList());
////        userStream.forEach(consumer);
////
//        String value = null;
////        value.substring(1);
//
//
//
////        long count = stream.filter(predicate).count();
////        System.out.println(count);
//
//
////        for (Result r: results) {
////            System.out.println(r);
////        }
////
////        Test<String> test = x-> {
////            Scanner sc = new Scanner(System.in);
////            if(x.equals("1")){
////                String s = sc.nextLine();
////                String revers = revers(s);
////                System.out.println(revers);
////            } else {
////                int i = sc.nextInt();
////                System.out.println(i+ "factorial");
////
////            }
////        };
////
////
////        String s = new Scanner(System.in).nextLine();
////        test.test(s);
////
}
