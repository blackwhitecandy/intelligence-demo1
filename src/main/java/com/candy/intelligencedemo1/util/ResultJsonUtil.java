package com.candy.intelligencedemo1.util;
import com.candy.intelligencedemo1.constant.Constants;
import com.candy.intelligencedemo1.entity.Patent;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultJsonUtil {
    /**
     * 处理返回结果，然后页面需要的数据类型
     * @param result
     * @return
     */
    public static Map<String, Object> dealResult(String result) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Patent> patentList = new ArrayList<>();
        //在用json提交数据的时候发现有时候会报这个异常，经过跟踪后台以及录入的数据发现用户在录入完成后习惯在句末加一个回车符，
        // 导致json格式不符合要求。根据这个发现找出的解决办法是将该变量中所有的换行符进行替换。在展示的时候使用硬换行就可以了。
        result = result.replaceAll(Constants.LINE_BREAK, "");//将该变量中出现的所有的换行符转换成空格。

        JSONObject jsonObject = JSONObject.fromObject(result);
        //返回结果不为0条 进行处理  如果为0条  则设置indexno为0
        if (null != jsonObject.getString(Constants.KEY_RETURN_CODE) && Constants.RETURN_CODE.equals(jsonObject.getString(Constants.KEY_RETURN_CODE))) {
            //引擎对待检专利自动抽取的关键词，以英文分号间隔
            String keyWords = jsonObject.getString(Constants.KEY_SPLIT_KEY_WORDS);
            if (null != keyWords && !keyWords.isEmpty()) {
                String[] splitKeyWords = keyWords.split(Constants.COMMA);
                resultMap.put("splitKeyWords", splitKeyWords);
            }

            //注意：results中的内容带有中括号[]，所以要转化为JSONArray类型的对象  resultInfo
            JSONArray resultInfoArr = jsonObject.getJSONArray(Constants.KEY_RESULT_INFO);
            for (int i = 0; i < resultInfoArr.size(); i++) {
                JSONObject patentJsonObject = resultInfoArr.getJSONObject(i);
                Patent patent = new Patent();
                patent.setSqh(patentJsonObject.getString(Constants.KEY_AN));
                patent.setGkh(patentJsonObject.getString(Constants.KEY_PN));
                patent.setCountry(patentJsonObject.getString(Constants.KEY_CO));
                patent.setDocType(patentJsonObject.getString(Constants.KEY_DOC_TYPE_I));
                patent.setGkr(patentJsonObject.getString(Constants.KEY_PD));
                patent.setZflh(patentJsonObject.getString(Constants.KEY_SICR_S).replaceAll("\\[", "")
                        .replaceAll("\"", "").replaceAll("\\]", "")); // 主分类号
                patent.setZlmc(patentJsonObject.getString(Constants.KEY_TI)); // 发明名称
                patent.setSqr(patentJsonObject.getString(Constants.KEY_SQR)); // 申请日

                patentList.add(patent);
            }

            //检索到的专利结果集
            resultMap.put("patentList", patentList);

            //目标专利信息 list 第一条 展示在结果页上
            Patent targetPatent = new Patent();
            if (null != patentList && patentList.size() != 0) {
                targetPatent = patentList.get(0);
            }
            resultMap.put("patent", targetPatent);
            resultMap.put("zflh", targetPatent.getZflh());
        } else {
            return new HashMap<>();
        }

        return resultMap;
    }
}
