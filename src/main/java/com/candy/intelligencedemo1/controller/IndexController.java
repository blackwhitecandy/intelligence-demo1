package com.candy.intelligencedemo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    /**
     * 跳转到检索首页
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index (@RequestParam String username, @RequestParam String password) {
        System.out.println(username + "-------------------------" +password);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("username", username);
        mv.addObject("password", password);
        return mv;
    }
}
