package com.web.controller.api;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.service.ChartService;

@RestController
public class ChartApiController {
	@Autowired
	ChartService service;
	
	@ResponseBody
	@RequestMapping("/chart/searchChart")
	public JSONObject searchChart() {
		return service.searchChart();
	}
	
	@ResponseBody
	@RequestMapping("/chart/userMonthChart")
	public JSONObject userMonthChart() {
		return service.userMonthChart();
	}
}