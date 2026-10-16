package kz.kbtu.webdev.hw2.controller.rest;

import kz.kbtu.webdev.hw2.entity.News;
import kz.kbtu.webdev.hw2.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResponseEntity<?> getAllNews() {
        List<News> news = newsService.loadAllNews();

        if(news.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
