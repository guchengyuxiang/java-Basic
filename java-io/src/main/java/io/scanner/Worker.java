package io.scanner;

public class Worker {
    private String name;
    private int age;
    private boolean inner;

    public Worker() {
    }

    public Worker(String name, int age, boolean inner) {
        this.name = name;
        this.age = age;
        this.inner = inner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isInner() {
        return inner;
    }

    public void setInner(boolean inner) {
        this.inner = inner;
    }

    @Override
    public String toString() {
        return name + '|' + age + "|" + inner;
    }
}
