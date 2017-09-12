package foo;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hi");
        System.out.println("sys cl: " + ClassLoader.getSystemClassLoader());
        System.out.println("sys cl: " + Thread.currentThread().getContextClassLoader());


    }
}
