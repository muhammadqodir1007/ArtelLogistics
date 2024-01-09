package com.example.artel.service;

import com.example.artel.entity.News;
import com.example.artel.payload.NewsDto;

import java.io.IOException;

public interface NewsService extends AbstractService<News,NewsDto> {

    @Override
    News insert(NewsDto news) throws IOException;


}
