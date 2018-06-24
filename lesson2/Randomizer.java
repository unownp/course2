package lesson2;

import java.lang.reflect.Field;

public class Randomizer {

    @RandomInt(min = 0, max = 300)
    private int z;

    public static void getRandomInt(Object object) throws IllegalAccessException {

        Class classOfObject = object.getClass();
        Field[] fields = classOfObject.getDeclaredFields();

        int result;
        for (Field field : fields) {
            RandomInt annotation = field.getAnnotation(RandomInt.class);

            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                result = (int) (min + max * Math.random());
                field.setAccessible(true);
                field.setInt(object, result);
                System.out.println(field.getInt(object));
            }
        }

    }

}
