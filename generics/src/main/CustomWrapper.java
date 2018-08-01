package main;

public class CustomWrapper {


    public <T> T printAndReturn(T obj){
        System.out.println(obj);

        return obj;
    }
}
