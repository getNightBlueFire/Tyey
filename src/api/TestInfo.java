package api;

import java.time.LocalDateTime;

public class TestInfo {
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
}
