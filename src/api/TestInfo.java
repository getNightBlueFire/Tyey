package api;

import java.time.LocalDateTime;

public class TestInfo implements Comparable<TestInfo>{
    private int age;
    private LocalDateTime date;

    public TestInfo(int age, LocalDateTime date) {
        this.age = age;
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestInfo{" +
                "age=" + age +
                ", date=" + date +
                '}';
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public int compareTo(TestInfo o) {
        if (this.getAge() == o.getAge()){
            if (this.getDate().isBefore(o.getDate())){
                return 1;
            } else {
                return -1;
            }
        }
        if(this.getAge()>o.getAge()){
            return -1;
        } else {
            return 1;
        }
    }
}
