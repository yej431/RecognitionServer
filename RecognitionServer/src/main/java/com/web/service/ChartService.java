package com.web.service;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.repository.SearchRankRepository;
import com.web.repository.UserRepository;

@Service
public class ChartService {
	@Autowired
	SearchRankRepository searchRankRepository;
	@Autowired
	UserRepository userRepository;

	public JSONObject searchChart() {
		List<Map<String, Object>> list = searchRankRepository.searchChart();
		
		System.out.println("list : " + list.get(0).toString());
		
		//최종적으로 리턴할 json 객체
		JSONObject data = new JSONObject();
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		
		JSONArray title = new JSONArray();
		col1.put("label", "키워드");
		col1.put("type", "string");
		col2.put("label", "검색 수");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		
		data.put("cols", title);
		
		JSONArray body = new JSONArray();
		for(Map<String, Object> map : list) {
			JSONObject keyword = new JSONObject();
			keyword.put("v", map.get("keyword"));
			JSONObject cnt = new JSONObject();
			cnt.put("v", map.get("cnt"));
			
			JSONArray row = new JSONArray();
			row.add(keyword);
			row.add(cnt);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			
			body.add(cell);
		}
		
		data.put("rows", body);
		return data;
	}
	
	public JSONObject userMonthChart() {
		List<Map<String, Object>> list = userRepository.userMonthChart();
		
		System.out.println("list : " + list.get(0).toString());
		
		//최종적으로 리턴할 json 객체
		JSONObject data = new JSONObject();
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		
		JSONArray title = new JSONArray();
		col1.put("label", "가입일");
		col1.put("type", "string");
		col2.put("label", "가입수");
		col2.put("type", "number");
		
		title.add(col1);
		title.add(col2);
		
		data.put("cols", title);
		
		JSONArray body = new JSONArray();
		for(Map<String, Object> map : list) {
			JSONObject joinDate = new JSONObject();
			joinDate.put("v", map.get("joinDate"));
			JSONObject cnt = new JSONObject();
			cnt.put("v", map.get("cnt"));
			
			JSONArray row = new JSONArray();
			row.add(joinDate);
			row.add(cnt);
			
			JSONObject cell = new JSONObject();
			cell.put("c", row);
			
			body.add(cell);
		}
		
		data.put("rows", body);
		return data;
	}
}