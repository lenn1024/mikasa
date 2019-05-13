package ai.code.mikasa.classloader;

import java.io.FileInputStream;
import java.io.IOException;

public class LennClassLoader extends ClassLoader {
    private String classPath;

    public LennClassLoader(String classPath) {
        this.classPath = classPath;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException{
        try {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0, data.length);
        }catch (Exception e){
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    private byte[] loadByte(String name) throws IOException {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();

        return data;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        LennClassLoader lennClassLoader = new LennClassLoader("/Users/lenn/lab");
        Class<?> clazz = lennClassLoader.loadClass("test.Person");

        System.out.println("我是由[" + clazz.getClassLoader().getClass() + "]加载进来的。");
    }
}
