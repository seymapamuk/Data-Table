package com.control;

import java.util.ArrayList;
import java.util.List;

import com.database.GetWorkerInfo;

public class Dummy {
	
	private int totaloptions;
	private List<String> options;
	
	public Dummy() {
	
		options = GetWorkerInfo.nameList();
		
		totaloptions = options.size();
	}
	
	public List<String> getData(String query) {
	
		String option = null;
		query = query.toLowerCase();
		
		List<String> matched = new ArrayList<String>();
		
		for(int i = 0; i < totaloptions; i++) {
			
			option = options.get(i).toLowerCase();
			
			if(option.startsWith(query)) {
				matched.add(options.get(i));
			}
		}
		
		return matched;
	}
}