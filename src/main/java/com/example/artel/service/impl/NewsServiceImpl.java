package com.example.artel.service.impl;

import com.example.artel.entity.News;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.image.ImageRepository;
import com.example.artel.repository.NewsRepository;
import com.example.artel.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class NewsServiceImpl implements NewsService {

    NewsRepository newsRepository;
    ImageRepository imageRepository;

    @Override
    public List<News> getAll() {
        return newsRepository.findAll();

    }

    @Override
    public News getById(int id) {
        return newsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("news not found"));
    }

    @Override
    public void deleteById(int id) {
        newsRepository.deleteById(id);

    }

    @Override
    public void update(int id, News news) {
        News editedNews = newsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("news not found"));

        editedNews.setTitle_en(news.getTitle_en());
        editedNews.setTitle_ru(news.getTitle_ru());
        editedNews.setTitle_uz(news.getTitle_uz());
        editedNews.setDescription_en(news.getDescription_en());
        editedNews.setDescription_uz(news.getDescription_uz());
        editedNews.setDescription_ru(news.getDescription_ru());
        newsRepository.save(editedNews);
    }

    @Override
    public News insert(News news) {
        return newsRepository.save(news);
    }

}
