package com.example.artel.service.impl;

import com.example.artel.entity.News;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.image.ImageDataService;
import com.example.artel.image.ImageRepository;
import com.example.artel.repository.NewsRepository;
import com.example.artel.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor

public class NewsServiceImpl implements NewsService {

    NewsRepository newsRepository;
    ImageRepository imageDataRepository;
    ImageDataService imageDataService;

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
    public void update(int id, News news) throws IOException {
        News editedNews = newsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("news not found"));
        News news1 = checkNews(editedNews, news);
        newsRepository.save(news1);
    }

    @Override
    public News insert(News news) throws IOException {
        news.setCreatedDate(LocalDateTime.now());
        return newsRepository.save(news);

    }

    private News checkNews(News first, News second) {
        if (second.getDescription_ru() != null) {
            first.setDescription_ru(second.getDescription_ru());
        }
        if (second.getDescription_uz() != null) {
            first.setDescription_uz(second.getDescription_uz());
        }
        if (second.getDescription_en() != null) {
            first.setDescription_en(second.getDescription_en());
        }
        if (second.getTitle_en() != null) {
            first.setTitle_en(second.getTitle_en());
        }
        if (second.getTitle_uz() != null) {
            first.setTitle_uz(second.getTitle_uz());
        }
        if (second.getTitle_ru() != null) {
            first.setTitle_ru(second.getTitle_ru());
        }
        if (second.getJpgName() != null) {
            first.setJpgName(second.getJpgName());
        }
        return first;

    }

}
