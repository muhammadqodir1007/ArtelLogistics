package com.example.artel.service.impl;

import com.example.artel.entity.News;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.image.ImageData;
import com.example.artel.image.ImageDataService;
import com.example.artel.image.ImageRepository;
import com.example.artel.image.ImageUtil;
import com.example.artel.payload.NewsDto;
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
    public void update(int id, NewsDto news) throws IOException {
        News editedNews = newsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("news not found"));
        ImageData imageData = ImageData.builder()
                .name(news.getFile().getOriginalFilename())
                .type(news.getFile().getContentType())
                .imageData(ImageUtil.compressImage(news.getFile().getBytes())).build();
//        editedNews.setImageData(imageData);
        editedNews.setTitle_en(news.getTitle_en());
        editedNews.setTitle_ru(news.getTitle_ru());
        editedNews.setTitle_uz(news.getTitle_uz());
        editedNews.setDescription_en(news.getDescription_en());
        editedNews.setDescription_uz(news.getDescription_uz());
        editedNews.setDescription_ru(news.getDescription_ru());
        newsRepository.save(editedNews);
    }

    @Override
    public News insert(NewsDto newsDto) throws IOException {
        ImageData imageData = ImageData.builder()
                .name(newsDto.getFile().getOriginalFilename())
                .type(newsDto.getFile().getContentType())
                .imageData(ImageUtil.compressImage(newsDto.getFile().getBytes())).build();
        News news = new News();
//        news.setImageData(imageData);
        news.setTitle_en(newsDto.getTitle_en());
        news.setTitle_uz(newsDto.getTitle_uz());
        news.setTitle_ru(newsDto.getTitle_ru());
        news.setCreatedDate(LocalDateTime.now());
        news.setDescription_uz(news.getDescription_uz());
        news.setDescription_en(news.getDescription_en());
        news.setDescription_ru(news.getDescription_ru());
        return newsRepository.save(news);
    }

}
