package dev.aniket.VideoCallApp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class HomeController {
    @GetMapping
    public ModelAndView homePage(ModelAndView modelAndView) {
        modelAndView.setViewName("home.html");
        return modelAndView;
    }
}
