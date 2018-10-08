package telegramBot.repository;


import telegramBot.QuestType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class QuestTypeRepositoryImpl implements QuestTypeRepository {
    private final SessionFactory factory;

    public QuestTypeRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public QuestType create(String awardType, String date, float longitude, float latitude) {
        QuestType questType = new QuestType();
        questType.setAwardType(awardType);
        questType.setDate(date);
        questType.setLatitude(latitude);
        questType.setLongitude(longitude);
        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();

        session.persist(questType);

        tr.commit();
        // session.close();

        return questType;
    }

    @Override
    public QuestType update(int id, String awardType, String date, float longitude, float latitude) {
        try (Session session = factory.openSession()) {
            Transaction tr = session.beginTransaction();

            QuestType questType = session.get(QuestType.class, id);
            if (questType == null) {
                tr.rollback();
                throw new NoRecordException(id);
            }
            questType.setAwardType(awardType);
            questType.setDate(date);
            questType.setLongitude(longitude);
            questType.setLatitude(latitude);
            tr.commit();

            return questType;
        }
    }

}
