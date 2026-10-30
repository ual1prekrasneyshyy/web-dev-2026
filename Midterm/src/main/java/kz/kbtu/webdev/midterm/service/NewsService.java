package kz.kbtu.webdev.midterm.service;

import kz.kbtu.webdev.midterm.entity.News;
import kz.kbtu.webdev.midterm.repository.NewsRepository;
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

    public News addArticle(News n){
        n.setViews(0);
        n.setPostedAt(LocalDateTime.now());
        return this.newsRepository.save(n);
    }

    public News viewDetails(Long id){
        Optional<News> o = this.newsRepository.findById(id);

        if(o.isEmpty()){
            return null;
        }

        News n = o.get();
        n.setViews(n.getViews() + 1);
        return this.newsRepository.save(n);  /// 1 more views should be saved
    }

    public News updateArticle(Long id, News dto){
        Optional<News> o = this.newsRepository.findById(id);

        if(o.isEmpty()){
            return null;
        }

        News n = o.get();
        ///  ID can not be changed
        n.setTitle(dto.getTitle());
        n.setContent(dto.getContent());
        ///  Amount of views can not be changed
        ///  Post date can not be changed
        return this.newsRepository.save(n);
    }

    public boolean deleteArticle(Long id){
        Optional<News> o = this.newsRepository.findById(id);

        if(o.isEmpty()){
            return false;   // if article is absent it can not be deleted
        }

        News n = o.get();
        this.newsRepository.deleteById(n.getId());
        return true;
    }
}
