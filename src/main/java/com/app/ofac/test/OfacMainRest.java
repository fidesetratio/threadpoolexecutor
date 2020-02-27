package com.app.ofac.test;

import java.util.List;

import com.app.ofac.Ofac;
import com.app.ofac.OfacRest;
import com.app.ofac.model.OfacResult;

public class OfacMainRest {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stubo
		OfacRest ofac = new OfacRest();
		List<OfacResult> res = ofac.search("Nasir",80);
		System.out.println(res.size());
		for(OfacResult o : res){
			System.out.println(o.getName()+"--"+o.getScore());
		}
	}
}
