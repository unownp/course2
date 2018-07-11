package lesson3;

import java.lang.reflect.Field;

/**
 * @author protsko on 21.06.18
 */
public class TeaProcessor {

    public static Object process(Object object) throws IllegalAccessException {

        Class classOfObject = object.getClass();

        Field[] fields = classOfObject.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            Object fieldValue = field.get(object);
            if (fieldValue != null) {
                continue;
            }

            Default annotation = field.getAnnotation(Default.class);
            if (annotation != null) {
                Class fieldType = field.getType();
                if (fieldType == String.class) {
                    field.set(object, annotation.value());
                } else if (fieldType == int.class) {

                } else if (fieldType == double.class) {

                }
            }

        }

        return object;
    }

}
