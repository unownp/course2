package lesson6;

public class TableExample {

    @PrimaryKeyAnnotation()
    int id;

    int price;

    @VarCharLimit()
    String login;

    @VarCharLimit(vcl = 30)
    String data;
}
