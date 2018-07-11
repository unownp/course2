package lesson6;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface CrudInterfaceExample {

    void create(Statement statement, String someTableClassName, ArrayList<String> tableFields) throws SQLException;

    void update(Statement statement, String someTableClassName, String cellAndValue) throws SQLException;

    void delete(Statement statement, String someTableClassName, String change, String value) throws SQLException;

    void getById(Statement statement, Object tableExample, int id) throws SQLException;

    void getAll(Statement statement, Object tableExample, int currentId) throws SQLException;


}
