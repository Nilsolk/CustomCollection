package utils;

public class LoggerUtils {
    public void log(Object object) {
        System.out.println(object);
    }

    public void log(Object... args) {
        for (Object obj : args) {
            System.out.println(obj);
        }
    }
}
