package lesson6;

import java.sql.*;
import java.util.ArrayList;

public class CrudExample implements CrudInterfaceExample {

    public void create(Statement statement, String someTableClassName, ArrayList<String> tableFields) throws SQLException {

        String sql = "create table if not exists" + " " + someTableClassName + " (";
        for (int i = 0; i < tableFields.size() - 1; i++) {
            sql += tableFields.get(i) + ", ";
        }
        sql += tableFields.get(tableFields.size() - 1);
        sql += ");";
        System.out.println(sql);
        statement.execute(sql);
    }

    public void update(Statement statement, String someTableClassName, String cellAndValue) throws SQLException {

        String sql = "update" + " " + someTableClassName + " " + "set" + " " + cellAndValue;
        System.out.println(sql);
        statement.execute(sql);
    }

    public void delete(Statement statement, String someTableClassName, String change, String value) throws SQLException {
        String sql = "delete from " + someTableClassName + " where " + change + " = \"" + value + "\";";
        System.out.println(sql);
        statement.execute(sql);
    }

    public void getById(Statement statement, Object tableExample, int id) throws SQLException {
        MethodsForTable methods = new MethodsForTable();
        String someTableClassName = methods.getTableExampleName(tableExample);

        String sql = "select * from " + someTableClassName + " where id = " + id + ";";

        ResultSet result = statement.executeQuery(sql);
        ArrayList<String> resultArray = new ArrayList<String>();
        ArrayList<String> fieldsName = methods.fieldsByName(tableExample);

        while (result.next()) {
            for (int i = 0; i < fieldsName.size(); i++) {
                resultArray.add(result.getString(fieldsName.get(i)));
                System.out.print(fieldsName.get(i) + " " + resultArray.get(i) + " ");
            }
        }
        System.out.println();


    }

    public void getAll(Statement statement, Object tableExample, int currentId) throws SQLException {
        for (int id = 1; id < currentId + 1; id++) {
            getById(statement, tableExample, id);
        }
    }


}
