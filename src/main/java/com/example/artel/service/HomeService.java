package com.example.artel.service;

import com.example.artel.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class HomeService {

    HiringRepository hiringRepository;
    InformationRepository informationRepository;
    ContactRepository contactRepository;
    NewsRepository newsRepository;
    VacancyRepository vacancyRepository;

    public Map<String, Long> count() {
        Map<String, Long> map = new HashMap<>();
        long hiring = hiringRepository.count() ;
        long information = informationRepository.count() ;
        long news = newsRepository.count() ;
        long vacancy = vacancyRepository.count() ;
        long contact = contactRepository.count() ;
        map.put("hiring", hiring);
        map.put("information", information);
        map.put("news", news);
        map.put("vacancy", vacancy);
        map.put("contact", contact);
        return map;
    }


}
