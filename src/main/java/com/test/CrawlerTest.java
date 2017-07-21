package com.test;

import org.apache.commons.collections4.CollectionUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by alexdrum on 2017/7/20.
 */
public class CrawlerTest {
    public static void main(String[] args) {
        parseDocumentFromUrl();
    }

    /**
     * 从URL加载
     *
     * @return Document
     */
    public static Document parseDocumentFromUrl() {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.tianyancha.com/search?key=自如&checkFrom=searchBox").get();
            //获取标题
            String title = doc.title();
            String content = doc.toString();
//            System.out.println(title);
            System.out.println(content);

            Elements elements = doc.getElementsByClass("search_result_single search-2017 pb20 pt20 pl30 pr30");
            if (CollectionUtils.isEmpty(elements)) {
                TestUtils.log("啥也没趴着！");
            }
            elements.forEach(e -> {
                System.out.println("\n ------------------------------------------------------------------------------- \n");
                System.out.println(e.toString());
            });
            //data(key,value)是该URL要求的参数
            //userAgent制定用户使用的代理类型
            //cookie带上cookie，如cookie("JSESSIONID","FDE234242342342423432432")
            //连接超时时间
            //post或者get方法
//            doc = Jsoup.connect("http://www.xxxxx.com/")
//                    .data("query", "Java")
//                    .userAgent("Mozilla")
//                    .cookie("auth", "token")
//                    .timeout(3000)
//                    .post();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}