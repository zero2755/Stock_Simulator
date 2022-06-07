package com.simulator.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
@Getter
@Setter
public class StockDTO {
	
	String stockName;
	String stockCode;
	
	String startDate;
	String endDate;
	int startPrice;
	int endPrice;
	int curPrice;
	
	List<StockDTO> StockDTOList;
 
	
}
