package telegramBot.repository;

import telegramBot.QuestType;


public interface QuestTypeRepository {


    QuestType create(String awardType, String currentDate, float longitude, float latitude);

    QuestType update(int id, String awardType, String date, float longitude, float latitude);

}
