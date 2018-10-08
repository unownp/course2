package telegramBot;


import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BotExample extends TelegramLongPollingBot {

    int caseButton = 0;
    int questTypeId = 1;
    Long chatId;
    Location location = new Location();
    final String dratini = "дратини";
    final String larvitar = "ларвитар";
    final String spinda = "спинда";
    final String rarka = "рарка";
    final String silverBerry = "серебряный ананас";
//    final String other="другое";


    HibernateBotClass hibernateBotClass = new HibernateBotClass();
    ArrayList<QuestType> arrayList = new ArrayList<>();

    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new BotExample());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "ololoNyaBot";

    }

    @Override
    public String getBotToken() {
        return "696507972:AAH-oCFyYgZeirXOQfZcO9RjQDO6dNvDvvI";

    }

    @Override
    public void onUpdateReceived(Update e) {
        Date date = new Date();
        Message message = e.getMessage();
        QuestType questType = new QuestType();

        if (message != null && message.hasText()) {
            switch (message.getText()) {

                case "/start":
                    sendMsg(message, "сообщите о квесте или узнайте о квесте ");
                    System.out.println(message.getChatId());
                    break;

                case "сообщить":
                    caseButton = 1;
                    sendMsg(message, "отправьте локу");
                    System.out.println(message.getChatId());
                    break;

                case dratini:
                    if (caseButton == 2) {
                        caseButton = 3;
                        questType.setId(questTypeId++);
                        questType.setAwardType(dratini);
                        questType.setLongitude(location.getLongitude());
                        questType.setLatitude(location.getLatitude());
                        questType.setCurrentDate(date);
                        questType.setDate(questType.dateFormation(date));

                        sendMsg(message, "tyvm for " + dratini);
                        arrayList.add(questType);
                        System.out.println(questType);

                        hibernateBotClass.hibernateIt(questType.getId(), dratini, questType.getDate(), questType.getLatitude(), questType.getLongitude());
                    }

                    caseButton = 0;
                    break;

                case larvitar:
                    if (caseButton == 2) {
                        caseButton = 3;
                        questType.setId(questTypeId++);
                        questType.setAwardType(larvitar);
                        questType.setLongitude(location.getLongitude());
                        questType.setLatitude(location.getLatitude());
                        questType.setCurrentDate(date);
                        questType.setDate(questType.dateFormation(date));

                        sendMsg(message, "tyvm for " + larvitar);
                        arrayList.add(questType);
                        System.out.println(questType);

                        hibernateBotClass.hibernateIt(questType.getId(), larvitar, questType.getDate(), questType.getLatitude(), questType.getLongitude());
                    }

                    caseButton = 0;
                    break;

                case spinda:
                    if (caseButton == 2) {
                        caseButton = 3;
                        questType.setId(questTypeId++);
                        questType.setAwardType(spinda);
                        questType.setLongitude(location.getLongitude());
                        questType.setLatitude(location.getLatitude());
                        questType.setCurrentDate(date);
                        questType.setDate(questType.dateFormation(date));

                        sendMsg(message, "tyvm for " + spinda);
                        arrayList.add(questType);
                        System.out.println(questType);

                        hibernateBotClass.hibernateIt(questType.getId(), spinda, questType.getDate(), questType.getLatitude(), questType.getLongitude());
                    }

                    caseButton = 0;
                    break;

                case rarka:
                    if (caseButton == 2) {
                        caseButton = 3;
                        questType.setId(questTypeId++);
                        questType.setAwardType(spinda);
                        questType.setLongitude(location.getLongitude());
                        questType.setLatitude(location.getLatitude());
                        questType.setCurrentDate(date);
                        questType.setDate(questType.dateFormation(date));

                        sendMsg(message, "tyvm for " + rarka);
                        arrayList.add(questType);
                        System.out.println(questType);

                        hibernateBotClass.hibernateIt(questType.getId(), rarka, questType.getDate(), questType.getLatitude(), questType.getLongitude());
                    }
                    caseButton = 0;
                    break;

                case silverBerry:
                    if (caseButton == 2) {
                        caseButton = 3;
                        questType.setId(questTypeId++);
                        questType.setAwardType(silverBerry);
                        questType.setLongitude(location.getLongitude());
                        questType.setLatitude(location.getLatitude());
                        questType.setCurrentDate(date);
                        questType.setDate(questType.dateFormation(date));

                        sendMsg(message, "tyvm for " + silverBerry);
                        arrayList.add(questType);
                        System.out.println(questType);

                        hibernateBotClass.hibernateIt(questType.getId(), silverBerry, questType.getDate(), questType.getLatitude(), questType.getLongitude());
                    }
                    caseButton = 0;
                    break;

//                case "/getlocation":
//                    chatId = message.getChatId();
//                    sendLoc(location);
//                    break;
                case "узнать":
                    caseButton = 10;
                    break;

                default:
                    caseButton = 0;

            }
        }

        if (message != null && message.hasLocation() && (caseButton == 1)) {
            System.out.println(message.getLocation());
            location = message.getLocation();
            caseButton = 2;
            sendMsg(message, "выберите квест ");
        }


        System.out.println(caseButton);
    }


    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);

        setButtons(sendMessage);

        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);


        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

//    private void sendLoc(Location location) {
//        SendLocation sendLocation = new SendLocation();
//        sendLocation.setChatId(chatId);
//        sendLocation.setLatitude(location.getLatitude());
//        sendLocation.setLongitude(location.getLongitude());
//
//        try {
//            execute(sendLocation);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//
//    }

    public synchronized void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        switch (caseButton) {
            case 0:

                keyboardFirstRow.add("сообщить");
                keyboardFirstRow.add("узнать");
                keyboard.add(keyboardFirstRow);
                break;

            case 2:

                keyboardFirstRow.add(dratini);
                keyboardFirstRow.add(spinda);
                keyboardSecondRow.add(larvitar);
                keyboardSecondRow.add(rarka);
                keyboardThirdRow.add(silverBerry);
                // keyboardThirdRow.add("другое");
                keyboard.add(keyboardFirstRow);
                keyboard.add(keyboardSecondRow);
                keyboard.add(keyboardThirdRow);
                break;
        }

        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
    }

}
