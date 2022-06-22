package com.simulator.simulator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simulator.DTO.StockDTO;
import com.simulator.mapper.StockMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class StockMapperTest {
	@Setter(onMethod_= @Autowired)
	private StockMapper mapper;
	
	@Test
	public void testGetList() {
		
		StockDTO dto=new StockDTO();
		dto.setStockDTOList(mapper.getStockList().getStockDTOList());
		
		System.out.println(dto.getStockDTOList());
		
		 
		 
	}
}
