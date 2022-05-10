package com.craw.myapp;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.lang.model.element.Element;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
 
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//셀레니움  
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   /**
    * Simply selects the home view to render by returning its name.
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      logger.info("Welcome home! The client locale is {}.", locale);
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      
      String formattedDate = dateFormat.format(date);
      
      model.addAttribute("serverTime", formattedDate );
      
      return "home";
   }
   
   @RequestMapping(value = "/test", method = RequestMethod.GET)
   public String homeTest(Locale locale, Model model) {
      //final String inflearnUrl = "https://finance.daum.net/quotes/A035420#home";
      //final String inflearnUrl = "https://m.stock.naver.com/domestic/stock/005930/total";
        //Connection conn = Jsoup.connect(inflearnUrl);
        
      /*
        try {
            //Document document = conn.get();
            //Elements imageUrlElements = document.getElementsByClass("swiper-lazy");
            //System.out.println(document);
            //for (org.jsoup.nodes.Element element : imageUrlElements) {
            //    System.out.println(element);
            //}
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
      String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
      String WEB_DRIVER_PATH = "C:\\Users\\mysti\\Downloads\\chromedriver_win32\\chromedriver.exe"; //드라이버 경로
      try {
         System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
      } catch (Exception e) {
         e.printStackTrace();
      }
      
       ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        //String url = "https://finance.daum.net/quotes/A035420#home";
        //String url = "https://m.stock.naver.com/domestic/stock/005930/total";
        String url = "http://data.krx.co.kr/contents/MDC/STAT/MDCSTATBIGCHART.jsp";
        //http://data.krx.co.kr/contents/MDC/STAT/MDCSTATBIGCHART.jsp
        driver.get(url);
       // List<WebElement> el1 = driver.findElements(By.className("finance")); //카카오
        //List<WebElement> el1 = driver.findElements(By.className("international"));네이버
        List<WebElement> el1 = driver.findElements(By.className("dateArea")); //krx빅차트
         
        System.out.println(el1);
        for (WebElement x : el1) {
           System.out.println(x.getText());
           System.out.println(x);
           
        }
        System.out.println("abc");
      return "home";
   }
   
}
