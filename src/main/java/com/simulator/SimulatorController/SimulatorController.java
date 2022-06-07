package com.simulator.SimulatorController;

import dashin.cputil.*;
import java.util.*;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simulator.DTO.StockDTO;


@Controller
public class SimulatorController {
	
	
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1(Locale locale, Model model) {
		
		
		return "test1";
	}
	
	//최대키-벨류값 헬퍼함수
	Comparator<Entry<Integer,
	String>> comparator = new Comparator<Entry<Integer,String >  > () {
	    @Override public int compare(Entry<Integer, String > e1, Entry<Integer, String > e2) {
	        return e1.getValue().compareTo(e2.getValue());
	    }
	};
	
	@RequestMapping(value = "/StockIndex", method = RequestMethod.GET)
	public String StockIndex(Locale locale, Model model) {
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
		
		dashin.cpsysdib.ISysDib stockChart = dashin.cpsysdib.ClassFactory.createStockChart();  //차트정보객체
		

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
		StockDTO stockDTO= new StockDTO();
		//stockDTO.set
		stockDTO.setCurPrice(closePrice);
		
		stockDTO.setStartDate(Integer.toString(date1));
		
		model.addAttribute("stockDTO",stockDTO);
		return "StockIndex";
	}
	
	
	@RequestMapping(value = "/getSingleStock.po")
	@ResponseBody
	public HashMap<Integer, String> StockIndex2(Locale locale, Model model,HttpServletResponse response) {
		
		System.out.println("호출됨??");
		dashin.cputil.ICpCybos cpCybos= dashin.cputil.ClassFactory.createCpCybos();  //연결객체생성
		
		if(cpCybos.isConnect()!=1) {
			System.out.println("연결되지않z음");
		}else {
			System.out.println("연결됨");
		}
		
		dashin.cpsysdib.ISysDib stockChart = dashin.cpsysdib.ClassFactory.createStockChart(); //차트정보객체
		
		//요청할 데이터 정보를 셋팅
		stockChart.setInputValue(0, "A005930"); //종목코드
		stockChart.setInputValue(1, 49); //ASCII CODE 49 = '1' (기간으로 요청)
		stockChart.setInputValue(2, 20220603); //요청종료일
		stockChart.setInputValue(3, 20220430); //요청***시작****일
		stockChart.setInputValue(5, new int[] {0,1,2,3,4,5,8,18,19}); //요청항목 (API 확인바람)
		stockChart.setInputValue(6, 68); //ASCII CODE 68 = 'D' (일봉 요청)
		stockChart.setInputValue(9, 49); //ASCII CODE 49 = '1' (수정주가)
		stockChart.blockRequest();
		
		System.out.println(stockChart.getHeaderValue(3).toString());
		System.out.println(stockChart.getHeaderValue(1).toString());
		 
		int numData=Integer.parseInt((stockChart.getHeaderValue(3).toString()));
		int numField=Integer.parseInt((stockChart.getHeaderValue(1).toString()));
				 
		System.out.println(numData);
		System.out.println(numField);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		 
		for(int i=0; i<numData; i++) {
			for(int j=0; j<numField; j++) {
				//System.out.print("i는 "+i+" j 는 "+j+"//");
				System.out.print(stockChart.getDataValue(j,i)+"  ");
			} 
			System.out.println("========");
		}
		
		for(int i=0; i<numData; i++) {
			map.put(Integer.parseInt(stockChart.getDataValue(0,i).toString()) , stockChart.getDataValue(5,i).toString()); //날짜가 key 종가가 value
		}
	
		Integer maxKey = Collections.max(map.keySet());
		Integer minKey = Collections.min(map.keySet());
		
		/*
		 20220603  0  67200  67300  66800  66800  8222883  20220603  100.0  ========
20220602  0  66600  67000  66400  66700  14959443  20220602  100.0  ========
20220531  0  67500  67500  66700  67400  24365002  20220531  100.0  ========
20220530  0  67500  67800  66900  67700  14255484  20220530  100.0  ======== 
		 */
		//0과 5의정보가필요
		
		
		
		Entry<Integer, String> maxEntry = Collections.max(map.entrySet(), comparator);
		// Min Value의 key, value
		Entry<Integer, String> minEntry = Collections.min(map.entrySet(), comparator); 
		
		
		 System.out.println(maxEntry.getKey() + " : " + maxEntry.getValue());  
		 System.out.println(minEntry.getKey() + " : " + minEntry.getValue());
		
		//1,2 =>최대키값,벨류  3,4 =>최소키값,벨류
		map.put(1,maxEntry.getKey().toString());
		map.put(2, maxEntry.getValue());
		map.put(3,minEntry.getKey().toString());
		map.put(4,minEntry.getValue());
	 
		
		 
		
		return map;
	}
	
 
	
	
	
}
