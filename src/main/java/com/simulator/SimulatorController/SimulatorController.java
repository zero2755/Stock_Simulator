package com.simulator.SimulatorController;

import dashin.cputil.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simulator.DTO.StockDTO;


@Controller
public class SimulatorController {
	
	dashin.cputil.ICpCybos cpCybos= dashin.cputil.ClassFactory.createCpCybos(); //연결객체 
	dashin.cpsysdib.ISysDib stockChart = dashin.cpsysdib.ClassFactory.createStockChart(); //차트정보객체
	
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
		//dashin.cputil.ICpCybos cpCybos= dashin.cputil.ClassFactory.createCpCybos();
		
		if(cpCybos.isConnect()!=1) {
			//System.out.println("연결되지않음");
		}else {
			//System.out.println("연결됨");
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
		
		//dashin.cpsysdib.ISysDib stockChart = dashin.cpsysdib.ClassFactory.createStockChart();  //차트정보객체
		

		//요청할 데이터 정보를 셋팅
		/*
		stockChart.setInputValue(0, "A005930"); //종목코드
		stockChart.setInputValue(1, 49); //ASCII CODE 49 = '1' (기간으로 요청)
		stockChart.setInputValue(2, 20101230); //요청종료일
		stockChart.setInputValue(3, 20101230); //요청시작일
		stockChart.setInputValue(5, new int[] {0,1,2,3,4,5,8,18,19}); //요청항목 (API 확인바람)
		stockChart.setInputValue(6, 68); //ASCII CODE 68 = 'D' (일봉 요청)
		stockChart.setInputValue(9, 49); //ASCII CODE 49 = '1' (수정주가)
		*/


		//리퀘스트 수 제한에 걸린 경우 제한 시간만큼 대기
		/*
		int remainTime = cpCybos.limitRequestRemainTime();
		int remainCount = cpCybos.getLimitRemainCount(dashin.cputil.LIMIT_TYPE.LT_NONTRADE_REQUEST);

		if (remainCount <= 0) {
		    try{
		        Thread.sleep(remainTime + 1);
		    }catch(Exception e){
		        System.out.println("??");
		    }
		}
		*/
		//요청
		//stockChart.blockRequest();



		//수신
		//int tot = (Integer) stockChart.getHeaderValue(3); //수신한 데이터 갯수

		//int date1= Integer.parseInt(stockChart.getDataValue(0, 0).toString()); //수신한 0번째 데이터의 0번항목(날짜)
		//int closePrice = (Integer) stockChart.getDataValue(5, 0); //수신한 0번째 데이터의 5번 항목
		
		//System.out.println(tot);
		//System.out.println(date1);
		//System.out.println(closePrice);
		
		
		 
		
		stockChart.setInputValue(0, "A005930"); //종목코드
		stockChart.setInputValue(1, 49); //ASCII CODE 49 = '1' (기간으로 요청)
		stockChart.setInputValue(2, 20210531); //요청종료일
		stockChart.setInputValue(3, 20210531); //요청시작일
		stockChart.setInputValue(5, new int[] {0,1,2,3,4,5,8,18,19}); //요청항목 (API 확인바람)
		stockChart.setInputValue(6, 68); //ASCII CODE 68 = 'D' (일봉 요청)  //일봉 D 월 M 주 W 분 m 
		
		
		//stockChart.setInputValue(7,60); //분봉 설정, 60은 60분 
		stockChart.setInputValue(9, 49); //ASCII CODE 49 = '1' (수정주가)
		stockChart.blockRequest();
		
		//수신
		int tot = (Integer) stockChart.getHeaderValue(3); //수신한 데이터 갯수

		int date1= Integer.parseInt(stockChart.getDataValue(0, 0).toString()); //수신한 0번째 데이터의 0번항목(날짜)
		int closePrice = (Integer) stockChart.getDataValue(5, 0); //수신한 0번째 데이터의 5번 항목
		//System.out.println("구분");
		//System.out.println(tot);
		//System.out.println(date1);
		//System.out.println(closePrice);
		
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
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        
	 
		        
		 
		
		System.out.println("타임체커 Before");
		timeChecker();
		
		 
		//dashin.cputil.ICpCybos cpCybos= dashin.cputil.ClassFactory.createCpCybos();  //연결객체생성
		
		if(cpCybos.isConnect()!=1) {
			System.out.println("cybos 연결되지않음");
		}else {
			System.out.println("cybos 연결됨");
		}
		
		//dashin.cpsysdib.ISysDib stockChart = dashin.cpsysdib.ClassFactory.createStockChart(); //차트정보객체
		
		//요청할 데이터 정보를 셋팅
		stockChart.setInputValue(0, "A005930"); //종목코드
		stockChart.setInputValue(1, 49); //ASCII CODE 49 = '1' (기간으로 요청)
		stockChart.setInputValue(2, 20201230); //요청종료일
		stockChart.setInputValue(3, 20101230); //요청***시작****일
		stockChart.setInputValue(5, new int[] {0,1,2,3,4,5,8,18,19}); //요청항목 (API 확인바람)
		stockChart.setInputValue(6, 68); //ASCII CODE 68 = 'D' (일봉 요청)  //일봉 D 월 M77 주 W87 분 m109 
		//stockChart.setInputValue(7,60); //분봉 설정, 60은 60분 
		stockChart.setInputValue(9, 49); //ASCII CODE 49 = '1' (수정주가)
		stockChart.blockRequest();
		 
		 
		
		
		System.out.println("타임체커 After");
		timeChecker();
		
		System.out.println(stockChart.getHeaderValue(3).toString());
		System.out.println(stockChart.getHeaderValue(1).toString());
		 
		int numData=Integer.parseInt((stockChart.getHeaderValue(3).toString()));
		int numField=Integer.parseInt((stockChart.getHeaderValue(1).toString()));
		//map.put(1,maxEntry.getKey().toString());
		//map.put(2, maxEntry.getValue());
		//map.put(3,minEntry.getKey().toString());
		//map.put(4,minEntry.getValue());
	 
		
		System.out.println(numData);
		System.out.println(numField);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int checkMax=0;
		int maxDay=0;
		int checkMin=9999999;
		int minDay=0;
		for(int i=0; i<numData; i++) {
			for(int j=0; j<numField; j++) {
				//System.out.print("i는 "+i+" j 는 "+j+"//");
				//System.out.print(stockChart.getDataValue(j,i)+"  ");
				if(Integer.parseInt(stockChart.getDataValue(5,i).toString())>checkMax) {
					checkMax=Integer.parseInt(stockChart.getDataValue(5,i).toString());
					maxDay=Integer.parseInt(stockChart.getDataValue(0,i).toString());
				}
				if(Integer.parseInt(stockChart.getDataValue(5,i).toString())  < checkMin) {
					checkMin=Integer.parseInt(stockChart.getDataValue(5,i).toString());
					minDay=Integer.parseInt(stockChart.getDataValue(0,i).toString());
				}
			} 
			map.put(Integer.parseInt(stockChart.getDataValue(0,i).toString()) , stockChart.getDataValue(5,i).toString()); //날짜가 key 종가가 value
			//System.out.println("========");
			
			if(i==0) {
				System.out.println("!!!"+Integer.parseInt(stockChart.getDataValue(0,i).toString()));
			}else if(i==numData-1) {
				System.out.println("!!!"+Integer.parseInt(stockChart.getDataValue(0,i).toString()));
			}
		}
		
		//for(int i=0; i<numData; i++) {
		//	map.put(Integer.parseInt(stockChart.getDataValue(0,i).toString()) , stockChart.getDataValue(5,i).toString()); //날짜가 key 종가가 value
		//}
	
	 
		/*
		 20220603  0  67200  67300  66800  66800  8222883  20220603  100.0  ========
20220602  0  66600  67000  66400  66700  14959443  20220602  100.0  ========
20220531  0  67500  67500  66700  67400  24365002  20220531  100.0  ========
20220530  0  67500  67800  66900  67700  14255484  20220530  100.0  ======== 
		 */
		//0과 5의정보가필요
		
		
		
		//Entry<Integer, String> maxEntry = Collections.max(map.entrySet(), comparator);
		//Entry<Integer, String> minEntry = Collections.min(map.entrySet(), comparator); 
		
		//System.out.println(maxEntry.getKey() + "@최대@ : " + maxEntry.getValue());  	//최대
		//System.out.println(minEntry.getKey() + "@최소@ : " + minEntry.getValue());	//최소
		
		System.out.println("max ,day / min, day ==> "+checkMax+"##"+maxDay+"##"+checkMin+"##"+minDay);
		
		//1,2 =>최대키값,벨류  3,4 =>최소키값,벨류
		 
		map.put(1,Integer.toString(maxDay));
		map.put(2,Integer.toString(checkMax));
		map.put(3,Integer.toString(minDay));
		map.put(4,Integer.toString(checkMin));
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
		
		 
		
		return map;
	}
	
	public void timeChecker() {
		//dashin.cputil.LIMIT_TYPE값 0: 주문,계좌고나련 1: 시세요청 관련 2 실시간요청관련
		int remainCount = cpCybos.getLimitRemainCount(dashin.cputil.LIMIT_TYPE.LT_NONTRADE_REQUEST);
		
		System.out.println("남은 조회 가능 횟수: " + remainCount);
		int remainTime=cpCybos.limitRequestRemainTime()+200; //ms단위 일듯?, 안전을위해 200ms추가 
		if (remainCount <10) {
			
			System.out.println("조회 가능 횟수가 10미만이니 "+remainTime+"ms 대기");
			try {
				 
				Thread.sleep(remainTime);
				System.out.println("TIME CHECKER TRY SUCCESS, "+remainTime+"ms waited");
			} catch (InterruptedException e) {
				 
				e.printStackTrace();
				System.out.println("TIME CHECKER EXCEPTION");
			}
			
			
		}
		getCode();
		
	}
	
	
	
	@RequestMapping(value = "/getMultiStock.po")
	@ResponseBody
	public HashMap<Integer, String> getMultiStock(Locale locale, Model model,HttpServletResponse response) {
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        
		//코드의리스트를 받아올거임, 그리스트별로 호출을하면 결과값이 쌓일텐데 해쉬맵에서 +=벨류값해줘야되네 결국 포문을 한번 더돌어야하네 
		        
		 
		
		System.out.println("타임체커 Before");
		timeChecker();
		
		 
		//dashin.cputil.ICpCybos cpCybos= dashin.cputil.ClassFactory.createCpCybos();  //연결객체생성
		
		if(cpCybos.isConnect()!=1) {
			System.out.println("cybos 연결되지않음");
		}else {
			System.out.println("cybos 연결됨");
		}
		
		//dashin.cpsysdib.ISysDib stockChart = dashin.cpsysdib.ClassFactory.createStockChart(); //차트정보객체
		
		//요청할 데이터 정보를 셋팅
		stockChart.setInputValue(0, "A005930"); //종목코드
		stockChart.setInputValue(1, 49); //ASCII CODE 49 = '1' (기간으로 요청)
		stockChart.setInputValue(2, 20201230); //요청종료일
		stockChart.setInputValue(3, 20101230); //요청***시작****일
		stockChart.setInputValue(5, new int[] {0,1,2,3,4,5,8,18,19}); //요청항목 (API 확인바람)
		stockChart.setInputValue(6, 68); //ASCII CODE 68 = 'D' (일봉 요청)  //일봉 D 월 M77 주 W87 분 m109 
		//stockChart.setInputValue(7,60); //분봉 설정, 60은 60분 
		stockChart.setInputValue(9, 49); //ASCII CODE 49 = '1' (수정주가)
		stockChart.blockRequest();
		 
		 
		
		
		System.out.println("타임체커 After");
		timeChecker();
		
		System.out.println(stockChart.getHeaderValue(3).toString());
		System.out.println(stockChart.getHeaderValue(1).toString());
		 
		int numData=Integer.parseInt((stockChart.getHeaderValue(3).toString()));
		int numField=Integer.parseInt((stockChart.getHeaderValue(1).toString()));
		//map.put(1,maxEntry.getKey().toString());
		//map.put(2, maxEntry.getValue());
		//map.put(3,minEntry.getKey().toString());
		//map.put(4,minEntry.getValue());
	 
		
		System.out.println(numData);
		System.out.println(numField);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		int checkMax=0;
		int maxDay=0;
		int checkMin=9999999;
		int minDay=0;
		for(int i=0; i<numData; i++) {
			for(int j=0; j<numField; j++) {
				//System.out.print("i는 "+i+" j 는 "+j+"//");
				//System.out.print(stockChart.getDataValue(j,i)+"  ");
				if(Integer.parseInt(stockChart.getDataValue(5,i).toString())>checkMax) {
					checkMax=Integer.parseInt(stockChart.getDataValue(5,i).toString());
					maxDay=Integer.parseInt(stockChart.getDataValue(0,i).toString());
				}
				if(Integer.parseInt(stockChart.getDataValue(5,i).toString())  < checkMin) {
					checkMin=Integer.parseInt(stockChart.getDataValue(5,i).toString());
					minDay=Integer.parseInt(stockChart.getDataValue(0,i).toString());
				}
			} 
			map.put(Integer.parseInt(stockChart.getDataValue(0,i).toString()) , stockChart.getDataValue(5,i).toString()); //날짜가 key 종가가 value
			//System.out.println("========");
			
			if(i==0) {
				System.out.println("!!!"+Integer.parseInt(stockChart.getDataValue(0,i).toString()));
			}else if(i==numData-1) {
				System.out.println("!!!"+Integer.parseInt(stockChart.getDataValue(0,i).toString()));
			}
		}
		
	
		
		System.out.println("max ,day / min, day ==> "+checkMax+"##"+maxDay+"##"+checkMin+"##"+minDay);
		
		//1,2 =>최대키값,벨류  3,4 =>최소키값,벨류
		 
		map.put(1,Integer.toString(maxDay));
		map.put(2,Integer.toString(checkMax));
		map.put(3,Integer.toString(minDay));
		map.put(4,Integer.toString(checkMin));
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
		
		 
		
		return map;
	}
	
	public void getCode() {
		  // 종목 코드 확인
	    ICpStockCode iCpStockCode = ClassFactory.createCpStockCode();
	    String strName = iCpStockCode.codeToName("A056080");
	    System.out.println("코드번호 A056080, 종목명 : " + strName);

	    // 전체 종목 코드 불러오기
	    ICpCodeMgr codeMgr = ClassFactory.createCpCodeMgr();
	    // 리턴 형식이 object이지만 Object[]로 캐스팅하여 리스트를 받는다.
	    Object[] market = (Object[]) codeMgr.getStockListByMarket(CPE_MARKET_KIND.CPC_MARKET_KOSPI);
	    System.out.println("전체 종목 수 : " + market.length);

	    for(int i=0; i<market.length; i++) {
	    	System.out.print(market[i]+"@@@");
	        System.out.println(iCpStockCode.codeToName(market[i].toString()));
	    }
	}
	
	
	//@RequestParam(value="checkArray[]") List<string> arrayParams
	//public void test12( , @RequestParam(value="userId") ,String userId) {
		
	
	
	
	@RequestMapping(value = "/test123", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Resource> test(HttpServletRequest req)throws IOException{
		System.out.println(readBody(req));
		
		return null;
	}
	
	
	public static String readBody(HttpServletRequest request) throws IOException {
		
        BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(buffer);
        }
        return builder.toString();
	}

	
 
	
	
	
}
