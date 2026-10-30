package kz.kbtu.webdev.midterm.service;

import kz.kbtu.webdev.midterm.dto.SaveArticleDto;
import kz.kbtu.webdev.midterm.dto.ViewArticleDto;
import kz.kbtu.webdev.midterm.entity.News;
import kz.kbtu.webdev.midterm.mapper.ArticleMapper;
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

    @Autowired
    private ArticleMapper articleMapper;

    public List<ViewArticleDto> loadAllNews(){
        List<News> news = this.newsRepository.findAll();
        List<ViewArticleDto> dto = this.articleMapper.toDtoList(news);
        return dto;
    }

    public ViewArticleDto addArticle(SaveArticleDto dto){
        News n = this.articleMapper.toEntity(dto);
        n.setViews(0);
        n.setPostedAt(LocalDateTime.now());
        News savedArticle = this.newsRepository.save(n);
        return this.articleMapper.toDto(savedArticle);
    }

    public ViewArticleDto viewDetails(Long id){
        Optional<News> o = this.newsRepository.findById(id);

        if(o.isEmpty()){
            return null;
        }

        News n = o.get();
        n.setViews(n.getViews() + 1);
        News processedArticle = this.newsRepository.save(n);  /// 1 more views should be saved
        return this.articleMapper.toDto(processedArticle);
    }

    public ViewArticleDto updateArticle(Long id, SaveArticleDto dto){
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
        News savedArticle = this.newsRepository.save(n);
        return this.articleMapper.toDto(savedArticle);
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
