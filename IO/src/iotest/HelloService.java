package iotest;

public interface HelloService {
    public void say();

    default void print() {
        System.out.println("hello world");
    }
}
