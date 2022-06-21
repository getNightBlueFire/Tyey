import api.Response;
import api.Result;
import com.google.gson.Gson;
import example.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Supplier<Response> supplier = Main::getUser;
        Response response0 = supplier.get();
        List<Result> results = response0.getResults();

        Function<Result, User> function = r -> new User(r.getName().getFirst(), r.getRegistered().getAge(), r.getGender());

        Stream<Result> stream = results.stream();
        Stream<User> userStream = stream.map(function);


        Predicate<User> predicate = user -> user.getAge()<10 & user.getGender().equals("male");
        Stream<User> userStreamNew = userStream.filter(predicate);


        Consumer<User> consumer = user -> System.out.println(user);

        userStreamNew.forEach(consumer);


    }


    public static Response getUser() {
        String uri = "https://randomuser.me/api/";
        //TODO make different methods
        //String uri = "?results=10&noinfo";
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
}
