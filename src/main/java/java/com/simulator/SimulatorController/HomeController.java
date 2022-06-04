package com.simulator.SimulatorController;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dashin.cputil.*;
import java.util.*;

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
		
		dashin.cputil.ICpCybos cpCybos= dashin.cputil.ClassFactory.createCpCybos();
		
		if(cpCybos.isConnect()!=1) {
			System.out.println("연결되지않음");
		}else {
			System.out.println("연결됨");
		}
		
		//ICpCybos
		
		/*
		System.out.println("테스트시작-------------");
		
		System.out.println("연결 성공");
		//종목 코드 확인
		dashin.cputil.ICpStockCode icd =ClassFactory.createCpStockCode();
		String strName =icd.codeToName("A056080");
		System.out.println(strName);
		//전체종목 코드 불러오기
		dashin.cputil.ICpCodeMgr codeMgr = ClassFactory.createCpCodeMgr();
        //리턴 형식이 object이지만 Object[]로 캐스팅 하여 리스트를 받는다.
		Object[] market = (Object[]) codeMgr.getStockListByMarket(dashin.cputil.CPE_MARKET_KIND.CPC_MARKET_KOSPI);
		System.out.println(market.length);
		//테스트로 하나만 종목 이름 출력
		System.out.println(icd.codeToName(market[2].toString()));
		
		for (int i=0; i<10; i++) {
			System.out.println(icd.codeToName(market[i].toString()));
		}
		
		System.out.println("테스트끝------------");
		*/
		
		dashin.cpsysdib.ISysDib stockChart = dashin.cpsysdib.ClassFactory.createStockChart();
		

		//요청할 데이터 정보를 셋팅
		stockChart.setInputValue(0, "A005930"); //종목코드
		stockChart.setInputValue(1, 49); //ASCII CODE 49 = '1' (기간으로 요청)
		stockChart.setInputValue(2, 20101230); //요청종료일
		stockChart.setInputValue(3, 20101230); //요청시작일
		stockChart.setInputValue(5, new int[] {0,1,2,3,4,5,8,18,19}); //요청항목 (API 확인바람)
		stockChart.setInputValue(6, 68); //ASCII CODE 68 = 'D' (일봉 요청)
		stockChart.setInputValue(9, 49); //ASCII CODE 49 = '1' (수정주가)



		//리퀘스트 수 제한에 걸린 경우 제한 시간만큼 대기
		int remainTime = cpCybos.limitRequestRemainTime();
		int remainCount = cpCybos.getLimitRemainCount(dashin.cputil.LIMIT_TYPE.LT_NONTRADE_REQUEST);

		if (remainCount <= 0) {
		    try{
		        Thread.sleep(remainTime + 1);
		    }catch(Exception e){
		        System.out.println("??");
		    }
		}

		//요청
		stockChart.blockRequest();



		//수신
		int tot = (Integer) stockChart.getHeaderValue(3); //수신한 데이터 갯수

		int date1= Integer.parseInt(stockChart.getDataValue(0, 0).toString()); //수신한 0번째 데이터의 0번항목(날짜)
		int closePrice = (Integer) stockChart.getDataValue(5, 0); //수신한 0번째 데이터의 5번 항목
		
		System.out.println(tot);
		System.out.println(date1);
		System.out.println(closePrice);
		
		stockChart.setInputValue(0, "A005930"); //종목코드
		stockChart.setInputValue(1, 49); //ASCII CODE 49 = '1' (기간으로 요청)
		stockChart.setInputValue(2, 20210531); //요청종료일
		stockChart.setInputValue(3, 20210531); //요청시작일
		stockChart.setInputValue(5, new int[] {0,1,2,3,4,5,8,18,19}); //요청항목 (API 확인바람)
		stockChart.setInputValue(6, 68); //ASCII CODE 68 = 'D' (일봉 요청)
		stockChart.setInputValue(9, 49); //ASCII CODE 49 = '1' (수정주가)
		stockChart.blockRequest();
		
		//수신
		tot = (Integer) stockChart.getHeaderValue(3); //수신한 데이터 갯수

		date1= Integer.parseInt(stockChart.getDataValue(0, 0).toString()); //수신한 0번째 데이터의 0번항목(날짜)
		closePrice = (Integer) stockChart.getDataValue(5, 0); //수신한 0번째 데이터의 5번 항목
		System.out.println("구분");
		System.out.println(tot);
		System.out.println(date1);
		System.out.println(closePrice);
		
		model.addAttribute("curDay", date1);
		model.addAttribute("curPrice",closePrice);
		
		return "home";
	}
	
}
