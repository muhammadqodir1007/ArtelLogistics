package com.example.artel.telegram;

import com.example.artel.entity.Contact;
import com.example.artel.entity.Hiring;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@AllArgsConstructor
public class SenderTelegramBot {

    private final TelegramBot telegramBot;
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void sendContact(Contact contact) {
        executorService.submit(() -> {
            long chatId = telegramBot.getChatId();

            try {
                telegramBot.execute(new SendMessage(String.valueOf(chatId), formatContact(contact)));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        });
    }

    public void sendHiring(Hiring hiring) {
        executorService.submit(() -> {
            long chatId = telegramBot.getChatId();

            try {
                telegramBot.execute(new SendMessage(String.valueOf(chatId), formatHiring(hiring)));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        });
    }

    private String formatContact(Contact contact) {
        return "Contact" + "\n" + "\n" + "First Name: " + contact.getFirstName() + "\n" + "Second Name: " + contact.getSecondName() + "\n" + "Number: " + contact.getNumber() + "\n" + "Email: " + contact.getEmail() + "\n" + "Message: " + contact.getMessage() + "\n" + "\n" + "#contact";
    }

    private String formatHiring(Hiring hiring) {
        return "Hiring" + "\n" + "\n" + "Name: " + hiring.getName() + "\n" + "City: " + hiring.getCity() + "\n" + "Number: " + hiring.getPhone() + "\n" + "Email: " + hiring.getEmail() + "\n" + "Experience: " + hiring.getExperience() + "\n" + "Comment: " + hiring.getComment() + "\n" +
                "\n" + "#hiring";
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
