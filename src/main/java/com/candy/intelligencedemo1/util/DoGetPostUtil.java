package com.candy.intelligencedemo1.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class DoGetPostUtil {
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realURL = new URL(urlName);
            URLConnection conn = realURL.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36");
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            for (String s : map.keySet()) {
                System.out.println(s + "-->" + map.get(s));
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String sendPost(String url, String param) {
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36");
            //post设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"));
            //new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{\"keywords\":\"汽车;发动机\",\"splitkeywords\":\"输出特性转换装置;凸轮信号传感器;电控发动机;汽车起重机;\",\"returncode\":\"1\",\"message\":\"\",\"resultInfo\":\n" +
                "[{\"score\":128.75671,\"pd\":\"20080130\",\"sic_s\":null,\"ti\":\"汽车起重机用电控发动机输出特性转换装置\",\"sicr_s\":[\"F02D41/26\",\"F02D41/30\"],\"doc_type_i\":\"SYXX\",\"co\":\"上海;31\",\"an\":\"CN200620048343.6\",\"pn\":\"CN201013459Y\",\"sqr\":\"2006.11.30\"}\n" +
                ",{\"score\":90.85588,\"pd\":\"20080130\",\"sic_s\":null,\"ti\":\"电控发动机输出特性转换装置\",\"sicr_s\":[\"F02D41/26\"],\"doc_type_i\":\"SYXX\",\"co\":\"上海;31\",\"an\":\"CN200620048344.0\",\"pn\":\"CN201013460Y\",\"sqr\":\"2006.11.30\"}\n" +
                ",{\"score\":77.76007,\"pd\":\"20150422\",\"sic_s\":null,\"ti\":\"汽车起重机及控制其发动机怠速的方法、装置和系统\",\"sicr_s\":[\"F02D29/02\"],\"doc_type_i\":\"FMSQ\",\"co\":\"湖南;43\",\"an\":\"CN201110338053.0\",\"pn\":\"CN102505994B\",\"sqr\":\"2011.10.31\"}\n" +
                ",{\"score\":77.67062,\"pd\":\"20120620\",\"sic_s\":null,\"ti\":\"汽车起重机及控制其发动机怠速的方法、装置和系统\",\"sicr_s\":[\"F02D29/02\"],\"doc_type_i\":\"FMZL\",\"co\":\"湖南;43\",\"an\":\"CN201110338053.0\",\"pn\":\"CN102505994A\",\"sqr\":\"2011.10.31\"}\n" +
                ",{\"score\":77.006805,\"pd\":\"20150909\",\"sic_s\":null,\"ti\":\"汽车起重机及其发动机停缸控制方法、装置\",\"sicr_s\":[\"F02D17/02\",\"F02D29/02\"],\"doc_type_i\":\"FMZL\",\"co\":\"山东;37\",\"an\":\"CN201510364461.1\",\"pn\":\"CN104895683A\",\"sqr\":\"2015.06.26\"}\n" +
                ",{\"score\":76.4729,\"pd\":\"20140806\",\"sic_s\":null,\"ti\":\"汽车起重机\",\"sicr_s\":[\"B66C23/44\"],\"doc_type_i\":\"FMZL\",\"co\":\"湖南;43\",\"an\":\"CN201410163108.2\",\"pn\":\"CN103964319A\",\"sqr\":\"2014.04.22\"}\n" +
                ",{\"score\":76.4729,\"pd\":\"20160511\",\"sic_s\":null,\"ti\":\"汽车起重机\",\"sicr_s\":[\"B66C23/44\"],\"doc_type_i\":\"FMSQ\",\"co\":\"湖南;43\",\"an\":\"CN201410163108.2\",\"pn\":\"CN103964319B\",\"sqr\":\"2014.04.22\"}\n" +
                ",{\"score\":75.13182,\"pd\":\"20160316\",\"sic_s\":null,\"ti\":\"汽车起重机用发动机MAP控制器\",\"sicr_s\":[\"F02D29/00\"],\"doc_type_i\":\"SYXX\",\"co\":\"山东;37\",\"an\":\"CN201520694967.4\",\"pn\":\"CN205089461U\",\"sqr\":\"2015.09.09\"}\n" +
                ",{\"score\":72.939125,\"pd\":\"20160210\",\"sic_s\":null,\"ti\":\"汽车起重机的控制方法和控制装置与汽车起重机\",\"sicr_s\":[\"F02D29/04\",\"B66C23/36\"],\"doc_type_i\":\"FMSQ\",\"co\":\"湖南;43\",\"an\":\"CN201210558632.0\",\"pn\":\"CN103032185B\",\"sqr\":\"2012.12.20\"}\n" +
                ",{\"score\":72.27265,\"pd\":\"20150318\",\"sic_s\":null,\"ti\":\"汽车起重机工作模式切换电路及其油门系统\",\"sicr_s\":[\"F02D11/10\",\"B66C23/40\"],\"doc_type_i\":\"SYXX\",\"co\":\"北京;11\",\"an\":\"CN201420632295.X\",\"pn\":\"CN204212864U\",\"sqr\":\"2014.10.28\"}]}";
    }
}
