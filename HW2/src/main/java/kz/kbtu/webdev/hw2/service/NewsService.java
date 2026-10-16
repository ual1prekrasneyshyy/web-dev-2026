package kz.kbtu.webdev.hw2.service;

import kz.kbtu.webdev.hw2.entity.News;
import kz.kbtu.webdev.hw2.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<News> loadAllNews(){
        return this.newsRepository.findAll();
    }

    public News addArticle(String title, String content){
        return this.newsRepository.save(new News(null, title, content, 0, LocalDateTime.now()));
    }

    public News viewDetails(Long id){
        Optional<News> o = this.newsRepository.findById(id);

        if(o.isPresent()){
            News n = o.get();
            n.setViews(n.getViews() + 1);
            return this.newsRepository.save(n);
        }

        return null;
    }
}
