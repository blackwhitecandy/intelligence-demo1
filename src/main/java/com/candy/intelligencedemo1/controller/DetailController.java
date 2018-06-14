package com.candy.intelligencedemo1.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * created by guoguo_lz@126.com
 * 2018-05-22 15:41
 */
@Controller
public class DetailController {
    @RequestMapping("/detail")
    public String toDetail(HttpServletRequest request) {
        String sqh = request.getParameter("sqh");
        String dscwb = request.getParameter("ddscwb");
        System.out.println(sqh + dscwb + "oooooooooooooooooooooooooooooK");
        return "detail";
    }
}
