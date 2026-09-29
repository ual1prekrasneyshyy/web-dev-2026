package kz.narxoz.k8s.hw1.service;

import kz.narxoz.k8s.hw1.entity.News;
import kz.narxoz.k8s.hw1.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<News> loadAllNews(){
        return this.newsRepository.findAll();
    }
}
