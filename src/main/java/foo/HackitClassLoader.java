package foo;

import java.net.URL;

public class HackitClassLoader extends ClassLoader
{

    public HackitClassLoader(ClassLoader parent)
    {
      super(parent);
    }


    @Override public URL getResource(String name)
    {
        System.out.println("my system CL");
        return super.getResource(name);
    }
}
