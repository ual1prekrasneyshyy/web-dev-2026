package kz.kbtu.webdev.midterm.controller.rest;

import kz.kbtu.webdev.midterm.dto.SaveArticleDto;
import kz.kbtu.webdev.midterm.dto.ViewArticleDto;
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
    public ResponseEntity<?> getAllNews(@RequestParam(required = false) String title) {
        List<ViewArticleDto> dto = newsService.loadAllNews(title);

        if(dto.isEmpty()){
            return new ResponseEntity<>("Database empty", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewArticle(@PathVariable Long id) {
        ViewArticleDto n = newsService.viewDetails(id);

        if(Objects.isNull(n)){
            return new ResponseEntity<>("Article not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addArticle(@RequestBody SaveArticleDto dto) {
        ViewArticleDto n = newsService.addArticle(dto);
        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable Long id, @RequestBody SaveArticleDto dto) {
        ViewArticleDto n = newsService.updateArticle(id, dto);

        if(Objects.isNull(n)){
            return new ResponseEntity<>("Article not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletedArticle(@PathVariable Long id) {
        boolean deleted = newsService.deleteArticle(id);

        if(deleted){
            return new ResponseEntity<>("Article has been successfully deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>("Article not found", HttpStatus.NOT_FOUND);
    }
}
