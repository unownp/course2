package telegramBot;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import telegramBot.repository.QuestTypeRepository;
import telegramBot.repository.QuestTypeRepositoryImpl;

import java.util.Properties;


public class HibernateBotClass {
    public void hibernateIt(int id, String questAward, String date, float longitude, float latitude) {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.url",
                "jdbc:mysql://localhost:3306/telegramBot?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false&createDatabaseIfNotExist=true");
        properties.setProperty("hibernate.connection.driver_class",
                "com.mysql.cj.jdbc.Driver");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "root");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(properties)
                .build();

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(QuestType.class)
                .buildSessionFactory(registry);


        QuestTypeRepository repository = new QuestTypeRepositoryImpl(factory);
        QuestType questType1 = new QuestType();

        questType1 = repository.create(questAward, date, longitude, latitude);

        questType1 = repository.update(questType1.getId(), questAward, date, longitude, latitude);

        System.out.println(questType1);

        factory.close();
    }


}

