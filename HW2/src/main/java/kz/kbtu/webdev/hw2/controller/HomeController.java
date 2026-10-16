package kz.kbtu.webdev.hw2.controller;

import kz.kbtu.webdev.hw2.entity.News;
import kz.kbtu.webdev.hw2.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class HomeController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("news", newsService.loadAllNews());
        return "index";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable Long id){
        News n = newsService.viewDetails(id);
        if(Objects.nonNull(n)) {
            model.addAttribute("n", n);
            return "detail";
        }

        return "not-found";
    }

    @PostMapping("/add")
    public String addArticle(@RequestParam String title, @RequestParam String content){
        newsService.addArticle(title, content);
        return "redirect:/";
    }
}
