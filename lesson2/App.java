package lesson2;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        File packages = new File("src/main/java/lesson2/packages.txt");

        if (packages.exists()) {
            BufferedReader Reader = new BufferedReader(new FileReader(packages));
            String packageString1 = Reader.readLine();
            String packageString = ("src/main/java/" + packageString1 + "/").replace('.', '/');

            FileFinder search = new FileFinder();
            search.fileFinder(new File(packageString));
            ArrayList<File> fileArrayList = search.getFiles();
            ArrayList<File> resultFileArrayList = new ArrayList<File>();

            for (int i = 0; i < fileArrayList.size(); i++) {
                if (fileArrayList.get(i).getPath().endsWith(".java")) {
                    resultFileArrayList.add(fileArrayList.get(i));
                }
            }
            String[] resultArrayString = new String[resultFileArrayList.size()];
            ArrayList resultArrayClass = new ArrayList();
            ArrayList resultArrayObject = new ArrayList();
            for (int i = 0; i < resultFileArrayList.size(); i++) {
                resultArrayString[i] = packageString1 + "." + resultFileArrayList.get(i).getName();
                resultArrayString[i] = resultArrayString[i].substring(0, resultArrayString[i].length() - 5);

                Class someclass = Class.forName(resultArrayString[i]);
                if (!someclass.isAnnotation()) {
                    resultArrayClass.add(someclass);
                    resultArrayObject.add(someclass.newInstance());
                }
            }

            for (int i = 0; i < resultArrayObject.size(); i++) {
                System.out.println(resultArrayClass.get(i).toString());

            }


            for (int i = 0; i < resultArrayClass.size(); i++) {
                Field[] fields = resultArrayObject.get(i).getClass().getDeclaredFields();
                for (Field field : fields) {
                    System.out.println("The name of field: " + field.getName());
                    Randomizer.getRandomInt(resultArrayObject.get(i));
                }
            }


        }
    }
}
