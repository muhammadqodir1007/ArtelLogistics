package com.example.artel.service.impl;

import com.example.artel.entity.Question;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.repository.QuestionRepository;
import com.example.artel.service.QuestionService;
import com.example.artel.telegram.SenderTelegramBot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionsServiceImpl implements QuestionService {
    private final SenderTelegramBot senderTelegramBot;
    private final QuestionRepository questionRepository;


    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(int id) {
        return questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("question not found "));
    }

    @Override
    public void deleteById(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public void update(int id, Question question) {
        Question question1 = questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" question not found"));
        question1.setEmail(question.getEmail());
        question1.setFirstName(question.getFirstName());
        question1.setCity(question.getCity());
        question1.setComment(question.getComment());
        question1.setExperience(question.getExperience());
        question1.setLastName(question.getLastName());
        question1.setPhone(question.getPhone());
        question1.setZipCode(question.getZipCode());
        question1.setState(question.getState());
        questionRepository.save(question1);

    }

    @Override
    public Question insert(Question question) {
        senderTelegramBot.sendQuestion(question);
        return questionRepository.save(question);


    }
}
