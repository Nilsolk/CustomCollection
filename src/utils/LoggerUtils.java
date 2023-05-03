package utils;

import java.util.Arrays;

public class LoggerUtils {
    public void log(Object object) {
        System.out.println(object);
    }

    public void log(Object... args) {
        Arrays.stream(args).forEach(System.out::println);
    }
}
