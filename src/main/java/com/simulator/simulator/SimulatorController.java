package com.simulator.simulator;

import dashin.cputil.*;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SimulatorController {
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1(Locale locale, Model model) {
		
		
		return "test1";
	}
	
	@RequestMapping(value = "/StockIndex", method = RequestMethod.GET)
	public String StockIndex(Locale locale, Model model) {
		
		
		return "StockIndex";
	}
}
