package com.example.artel.service.impl;

import com.example.artel.entity.Banner;
import com.example.artel.exception.ResourceNotFoundException;
import com.example.artel.repository.BannerRepository;
import com.example.artel.service.BannerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class BannerServiceImpl implements BannerService {
    BannerRepository bannerRepository;


    @Override
    public List<Banner> getAll() {
        return bannerRepository.findAll();
    }

    @Override
    public Banner getById(int id) {
        return bannerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Banner Not Found"));
    }

    @Override
    public void deleteById(int id) {
        bannerRepository.deleteById(id);

    }

    @Override
    public void update(int id, Banner banner) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Banner insert(Banner bannerService) throws IOException {
        return bannerRepository.save(bannerService);
    }
}
