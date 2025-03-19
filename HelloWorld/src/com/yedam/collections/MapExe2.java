package com.yedam.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.yedam.variable.Member;

public class MapExe2 {
	public static void main(String[] args) {
		Map<Member, Double> map = new HashMap<Member, Double>();
		map.put(new Member("홍길동", 80), 174.8);
		map.put(new Member("김길동", 82), 179.4);
		map.put(new Member("강길동", 90), 182.2);
		
		map.remove(new Member("강길동", 90));
		
		Set<Entry<Member, Double>> entryset = map.entrySet();
		for(Entry<Member, Double> entry : entryset) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
	}
}
