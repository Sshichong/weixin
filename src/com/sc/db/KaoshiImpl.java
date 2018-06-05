package com.sc.db;

import java.util.ArrayList;
import java.util.List;

public class KaoshiImpl {
	public static List<Kaoshi> QueryKaoshi(String major){
		List<Kaoshi> ksList =new ArrayList<Kaoshi>();
		DataProcess db =new DataProcess();
		String sql="select * from exams where major='"+major+"'";
		List list =db.getData(sql);
		for(int i=0;i<list.size();i++) {
			Kaoshi k=new Kaoshi();
			List l =(List)list.get(i);
			k.setId(Integer.parseInt(String.valueOf(l.get(0))));
			k.setCampus(String.valueOf(l.get(1)));
			k.setTime(String.valueOf(l.get(2)));
			k.setCourse(String.valueOf(l.get(3)));
			k.setMajor(String.valueOf(l.get(4)));
			k.setDirection(String.valueOf(l.get(5)));
			k.setPlace(String.valueOf(l.get(6)));
			
			ksList.add(k);
			
		}
		return ksList;
	}

}
