package lesson6;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MethodsForTable {

    String getTableExampleName(Object tableExample) {
        String tableExampleShortClassName = tableExample.getClass().toString().substring(tableExample.getClass().toString().lastIndexOf('.') + 1, tableExample.getClass().toString().length()).toLowerCase();
        return tableExampleShortClassName;
    }

    ArrayList<String> SqlTypeConverter(Object tableExample) {
        ArrayList typesOfTable = new ArrayList();
        Field[] fields = tableExample.getClass().getDeclaredFields();

        for (Field field : fields) {
            VarCharLimit annotation = field.getAnnotation(VarCharLimit.class);
            PrimaryKeyAnnotation primaryKeyAnnotation = field.getAnnotation(PrimaryKeyAnnotation.class);
            if (field.getType().isPrimitive()) {
                if (primaryKeyAnnotation != null) {
                    typesOfTable.add(field.getName() + " " + field.getType() + " primary key ");
                } else typesOfTable.add(field.getName() + " " + field.getType() + " ");
            } else if (field.getType().toString().equals("class java.lang.String")) {
                if (annotation != null) {
                    typesOfTable.add(field.getName() + " " + "varchar (" + annotation.vcl() + ")");
                }
            }
        }
        return typesOfTable;
    }

    String cellAndValue(Object object, int primaryKey, String change, String value) {
        Field[] fields = object.getClass().getDeclaredFields();
        String result = "";
        result += change + " = \"" + value + "\" where " + fields[0].getName() + " = " + primaryKey + ";";
        return result;
    }

    Collection collectionObject(Object tableExample, int currentId) {
        Field[] fields = tableExample.getClass().getDeclaredFields();
        ArrayList<String> columns = new ArrayList<String>();

        for (Field field : fields) {
            if (field.getType().isPrimitive()) {
                columns.add(field.getName());

            } else if (field.getType().toString().equals("class java.lang.String")) {
                columns.add(field.getName());

            }
        }


        ArrayList values = new ArrayList();

        for (int i = 1; i < fields.length; i++) {
            if (fields[i].getType().isPrimitive()) {
                values.add(111);
            } else if (fields[i].getType().toString().equals("class java.lang.String")) {
                values.add("sadas");
            }
        }

        return values;
    }

    void insertValues(Collection collectionForInsert, int currentId, Connection connection, String tableExampleShortString) throws SQLException {
        Object[] arrayForInsert = collectionForInsert.toArray();
        Object[][] data = new Object[4][arrayForInsert.length + 1];

        for (int i = 0; i < 4; i++) {
            int j = 0;
            data[i][j] = currentId + 1;
            currentId++;
        }


        for (int i = 0; i < arrayForInsert.length + 1; i++) {
            for (int j = 1; j < 4; j++) {
                data[i][j] = arrayForInsert[j - 1];
            }
        }


        String QuestionSize = "";
        for (int i = 0; i < collectionForInsert.size(); i++) {
            QuestionSize += "?, ";
        }

        for (Object[] dataArray : data) {

            PreparedStatement insert = connection
                    .prepareStatement("INSERT INTO " + tableExampleShortString + " VALUES (" + QuestionSize + "?)");
            int parameter = 1;
            for (Object columnValue : dataArray) {
                insert.setObject(parameter++, columnValue);
            }
            insert.executeUpdate();
        }

    }

    ArrayList<String> fieldsByName(Object tableExample) {
        ArrayList<String> fieldsByName = new ArrayList<String>();
        Field[] fields = tableExample.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().isPrimitive()) {
                fieldsByName.add(field.getName());

            } else if (field.getType().toString().equals("class java.lang.String")) {
                fieldsByName.add(field.getName());
            }
        }

        return fieldsByName;
    }
}
