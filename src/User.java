import java.util.Collection;
import java.util.List;
import java.util.Set;

public class User {
    private String name;
    private Integer age;
    private String lastName;
    private Boolean hasAnimal;
    private List<? extends Set<Integer>> rates;
    private List<? super Set<Integer>> test;

    public User() {
    }
        private User(String name, Integer age, String lastName, Boolean hasAnimal) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
        this.hasAnimal = hasAnimal;
    }

    public static User builder(){
        return new User();
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getHasAnimal() {
        return hasAnimal;
    }

    public User setHasAnimal(Boolean hasAnimal) {
        this.hasAnimal = hasAnimal;
        return this;
    }


    public User(List<? extends Set<Integer>> rates, List<? super Set<Integer>> test) {
        this.rates = rates;
        this.test = test;
    }

    public List<? extends Set<Integer>> getRates() {
        return rates;
    }
}
