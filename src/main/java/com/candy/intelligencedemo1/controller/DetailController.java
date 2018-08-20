package com.candy.intelligencedemo1.controller;

import com.candy.intelligencedemo1.constant.Constants;
import com.candy.intelligencedemo1.entity.Patent;
import com.candy.intelligencedemo1.util.DoGetPostUtil;
import com.candy.intelligencedemo1.util.ResultJsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * created by guoguo_lz@126.com
 * 2018-05-22 15:41
 */
@Controller
public class DetailController {
    /**
     * 跳转到检索后结果页面
     * @param request
     * @return
     */
    @RequestMapping("/detail")
    public ModelAndView toDetail(HttpServletRequest request) {
        String text = request.getParameter("reviewedText"); // 必填，需要进行相似度检索的文本
        String strSource = request.getParameter("strSources"); // 必填，检索范围 检索范围分为名称，摘要，权利要求，说明书，多范围检索时以英文分号间隔
        String startIndex =
                null == request.getParameter("startIndex")?String.valueOf(0):request.getParameter("startIndex"); // 选填，开始行，默认从第0行开始
        String strLine = "10"; // 选填，返回结果的行数，默认返回10行
        String keywords = request.getParameter("keywords"); //选填，用户添加的关键词

        String flh = request.getParameter("flh"); // 分类号
        String sqren = request.getParameter("sqren"); // 申请人
        String fmren = request.getParameter("fmren"); // 发明人
        String sqrStart = request.getParameter("sqrStart"); // 申请日开始
        String sqrEnd = request.getParameter("sqrEnd"); // 申请日结束

        System.out.println(text + "-------------：text");
        System.out.println(strSource + "-------------：strSource");
        System.out.println(startIndex + "-------------：startIndex");
        System.out.println(strLine + "-------------：strLine");
        System.out.println(keywords + "-------------：keywords");
        System.out.println(flh + "-------------：flh");
        System.out.println(sqren + "-------------：sqren");
        System.out.println(fmren + "-------------：fmren");
        System.out.println(sqrStart + "-------------：sqrStart");
        System.out.println(sqrEnd + "-------------：sqrEnd");

        String result = DoGetPostUtil.sendPost("http://localhost:8080/", "");
        Map<String, Object> resultMap = new HashMap<>();
        //处理返回结果
        resultMap = ResultJsonUtil.dealResult(result);
        String flhzs = resultMap.get("zflh").toString(); //获取主分类号 继续处理展示到页面上
        //去掉  [  ]   "  "
        flhzs = flhzs.replaceAll("\\[", "")
                .replaceAll("\"", "").replaceAll("\\]", "");
        //加载返回结果到页面model
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("patent", resultMap.get("patent"));
        modelAndView.addObject("patentList", resultMap.get("patentList"));
        modelAndView.addObject("splitKeyWords", resultMap.get("splitKeyWords"));
        modelAndView.addObject("search_flh", flh.split(Constants.COMMA));
        modelAndView.addObject("flhzs", flhzs);

        return modelAndView;
    }
}
