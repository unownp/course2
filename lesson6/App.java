package lesson6;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


public class App {


    public static void main(String[] args) throws SQLException {


        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/online_shop?useSSL=false&serverTimezone=UTC",
                "root", "root");


        TableExample tableExample = new TableExample();
        MethodsForTable methods = new MethodsForTable();
        String tableExampleShortString = methods.getTableExampleName(tableExample);
        System.out.println(tableExampleShortString);
        ArrayList<String> columns = methods.SqlTypeConverter(tableExample);

        for (int i = 0; i < columns.size(); i++) {
            System.out.println(columns.get(i));
        }


        Statement statement = connection.createStatement();
        CrudExample crudExample = new CrudExample();
        crudExample.create(statement, tableExampleShortString, columns);

        String cellAndValue = methods.cellAndValue(tableExample, 9, "login", "ololo");
        crudExample.update(statement, tableExampleShortString, cellAndValue);

        crudExample.delete(statement, tableExampleShortString, "login", "sadas");


        statement.close();


        statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT MAX(id) FROM " + tableExampleShortString);
        result.next();
        int currentId = result.getInt(1);


        Collection collectionForInsert = methods.collectionObject(tableExample, currentId);
        methods.insertValues(collectionForInsert, currentId, connection, tableExampleShortString);
        crudExample.getById(statement, tableExample, 20);


        crudExample.getAll(statement, tableExample, currentId);

        connection.close();

    }

}
