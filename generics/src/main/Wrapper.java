package main;

public class Wrapper<T,E,Z> extends Person<Z>{
    private T obj;
    private E obj2;
    private Z obj3;

    public void print(T obj){
        System.out.println(obj);
    }

    public <E> E printAsIWant(E obj){
        return obj;
    }

    public void sendObjAsEmail(T obj, String to){
        //obj email olaraq gonderecek
    }

    public  T getT(){
        return obj;
    }

    public E getE(){
        return obj2;
    }

    public Z getZ(){
        return obj3;
    }
}
