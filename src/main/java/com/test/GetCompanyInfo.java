package com.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.test.TestConst.*;

/**
 * Created by alexdrum on 2017/7/24.
 */
public class GetCompanyInfo {
    /**
     * 通过种子信息向天眼通抓取企业信息
     */
    public void saveFromTianYanCha() throws IOException {
        long nowTime = DateUtils.formatNow2Long();

        // 从excel文件中获取种子关键字集合
        List<String> keyList = Lists.newArrayList();
        String filePath = TestConst.WIN_ROOT;
        String os = System.getProperty("os.name");
        if (!os.toLowerCase().startsWith("win")) {
            filePath = TestConst.LINUX_ROOT;
        }
        String fullPathFileName = filePath + SEED_FILE;
        // 创建输入流
        InputStream stream = new FileInputStream(fullPathFileName);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet;
        XSSFRow row;
        try {
            wb = new XSSFWorkbook(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            XSSFCell xssfCell = row.getCell(0);
            try {
                String keyWord = xssfCell.getRichStringCellValue().getString();
                //把刚获取的列存入list
                keyList.add(keyWord);
                System.out.println("已读取第" + i + "条数据：" + keyWord);
            } catch (IllegalStateException e) {
                continue;
            }
        }

        System.out.println("已经初始化关键字，共：" + keyList.size() + "个。");

        // 通过关键字从目标网站上抓取数据
        for (String keyWord : keyList) {
            String searchURL = TIAN_YAN_CHA_PREFIX + keyWord + TIAN_YAN_CHA_SUFFIX;
            Document doc = null;
            try {
                doc = Jsoup.connect(searchURL).get();
            } catch (IOException ioException) {
                System.out.println("获取网页失败！");
            }

            Elements elements = doc.getElementsByClass("search_result_single search-2017 pb20 pt20 pl30 pr30");
            if (CollectionUtils.isEmpty(elements)) {
                System.out.println("啥也没爬着！");
            }
            for (Element element : elements) {
                // 获取公司名称
                Elements nameDiv = element.getElementsByClass("mr20 search_left_icon");
                String companyName = nameDiv.get(0).child(0).attr("alt");

                // 获取图片文件并保存到图片平台
                String picURL = nameDiv.get(0).child(0).attr("src");

                // 获取省份
                Elements provinceDiv = element.getElementsByClass("search_right_item");
                String provinceDivString = provinceDiv.get(0).child(0).child(1).toString();
                String province = provinceDivString.substring(provinceDivString.indexOf("</i>") + 4, provinceDivString.indexOf(" \n <div class=\"notInIE8 position-abs\""));

                // 获得公司名称、法人姓名、注册日期、品牌
                Elements infoDiv = element.getElementsByClass("search_row_new");
                String createName = infoDiv.get(0).child(0).child(0).text();
                String registeredCapitalString = infoDiv.get(0).child(1).child(0).text();
                Double registeredCapital = Double.valueOf(registeredCapitalString.substring(0, registeredCapitalString.indexOf("万人民币")).trim());
                registeredCapital = registeredCapital * 10000L;
                String foundDateString = infoDiv.get(0).child(2).child(0).text();
                Integer foundDate = Integer.valueOf(foundDateString.replace("-", ""));
                String brand = "";
                try {
                    brand = infoDiv.get(0).child(3).child(0).child(2).text();
                } catch (Exception exception) {
                    System.out.println("没有品牌信息");
                }

                CompanyEntity companyEntity = new CompanyEntity();
                companyEntity.setName(companyName);
                companyEntity.setCreateName(createName);
                companyEntity.setProvince(province);
                companyEntity.setRegisteredCapital(registeredCapital);
                companyEntity.setFoundDate(foundDate);
                companyEntity.setBrand(brand);
                companyEntity.setLogo(picURL);
                companyEntity.setCreateTime(nowTime);
            }
        }
    }
}
