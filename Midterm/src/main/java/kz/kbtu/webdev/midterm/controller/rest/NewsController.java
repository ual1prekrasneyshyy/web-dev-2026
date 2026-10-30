package kz.kbtu.webdev.midterm.controller.rest;

import kz.kbtu.webdev.midterm.entity.News;
import kz.kbtu.webdev.midterm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> viewArticle(@PathVariable Long id) {
        News n = newsService.viewDetails(id);

        if(Objects.isNull(n)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addArticle(@RequestBody News dto) {
        News n = newsService.addArticle(dto);
        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable Long id, @RequestBody News dto) {
        News n = newsService.updateArticle(id, dto);

        if(Objects.isNull(n)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<?> deletedArticle(@PathVariable Long id) {
        boolean deleted = newsService.deleteArticle(id);

        if(deleted){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
