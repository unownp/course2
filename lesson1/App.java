package lesson1;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class App {
    public static String toString(Object object) {

    //    ArrayList<String> resultArray=new ArrayList<>();
        String result="";
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
           if (field.getType().isPrimitive()||field.getType().isArray()||field.getType().toString().equals("class java.lang.String")){
           System.out.println(field.getType());
            }
            else System.out.println(field.getType());}
        //    else toString(field);}

        return result;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class someclass = Class.forName("lesson1.ClassForSomeObject");
        Object object=someclass.newInstance();
        System.out.println(toString(object));



       // System.out.println((field.getType().toString().equals("class java.lang.String")));

    }
}
