/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.artel.telegram;

import com.example.artel.entity.Contact;
import com.example.artel.entity.Question;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@AllArgsConstructor
public class SenderTelegramBot {

    private final TelegramBot telegramBot;

    public void sendContact(Contact contact) {
        long chatId = telegramBot.getChatId();

        try {
            telegramBot.execute(new SendMessage(String.valueOf(chatId), formatContact(contact)));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendQuestion(Question question) {
        long chatId = telegramBot.getChatId();

        try {
            telegramBot.execute(new SendMessage(String.valueOf(chatId), formatQuestion(question)));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private String formatContact(Contact contact) {
        return "Contact" + "\n" + "\n" +
                "First Name: " + contact.getFirstName() + "\n" +
                "Second Name: " + contact.getSecondName() + "\n" +
                "Number: " + contact.getNumber() + "\n" +
                "Email: " + contact.getEmail() + "\n" +
                "Message: " + contact.getMessage() + "\n" + "\n" +
                "#contact"
                ;
    }


    private String formatQuestion(Question question) {

        return "Question" + "\n\n" +
                "First Name: " + question.getFirstName() + "\n" +
                "Last Name: " + question.getLastName() + "\n" +
                "State: " + question.getState() + "\n" +
                "City: " + question.getCity() + "\n" +
                "Zip Code: " + question.getZipCode() + "\n" +
                "Phone: " + question.getPhone() + "\n" +
                "Email: " + question.getEmail() + "\n" +
                "Experience: " + question.getExperience() + "\n" +
                "Comment: " + question.getComment() + "\n\n" +
                "#question";
    }


}

