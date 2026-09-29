package kz.narxoz.k8s.hw1.controller;

import kz.narxoz.k8s.hw1.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("news", newsService.loadAllNews());
        return "index";
    }
}
