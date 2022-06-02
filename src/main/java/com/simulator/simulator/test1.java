package com.simulator.simulator;

import dashin.cputil.*;
import java.util.*;

public class test1 {
	public static void main(String[] args) {
			
			System.out.println("���� ����");
			
			dashin.cputil.ICpStockCode icd =ClassFactory.createCpStockCode();
			String strName =icd.codeToName("A056080");
			System.out.println(strName);
			
			dashin.cputil.ICpCodeMgr codeMgr = ClassFactory.createCpCodeMgr();
          
			Object[] market = (Object[]) codeMgr.getStockListByMarket(dashin.cputil.CPE_MARKET_KIND.CPC_MARKET_KOSPI);
			System.out.println(market.length);
			
			System.out.println(icd.codeToName(market[3].toString()));
				
	}
 	
}