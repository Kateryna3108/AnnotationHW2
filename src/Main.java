import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Container container = new Container();
        Class<?> cls = container.getClass();
        SaveTo ann = cls.getAnnotation(SaveTo.class);
        if(cls.isAnnotationPresent(SaveTo.class)) {
            Method[] methods = cls.getDeclaredMethods();
            for (Method method: methods) {
                if(method.isAnnotationPresent(Saver.class)) {
                    try {
                        method.invoke(container, ann.path());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}