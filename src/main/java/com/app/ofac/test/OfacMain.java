package com.app.ofac.test;

import java.util.List;

import com.app.ofac.Ofac;
import com.app.ofac.model.OfacAddress;
import com.app.ofac.model.OfacAlias;
import com.app.ofac.model.OfacIdentification;
import com.app.ofac.model.OfacResult;
import com.app.ofac.model.OfacResultDetail;

public class OfacMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stubo
		Ofac ofac = new Ofac();
		
		  try { 
			List<OfacResult> results = ofac.search("", "Muhammad iqbal", "",
		  "SDGT", 100,"", "", "", "", ""); System.out.println(results.size());
		  
		  System.out.println(ofac.getGetTotalSearchTime());
		  }catch(Exception e) {
			  
		  }
		
		try {
			OfacResultDetail ofacDetail = ofac.findByOfacId(2791);

			System.out.println("detail:");
			System.out.println(ofacDetail.getDetails().getType());
			System.out.println(ofacDetail.getDetails().getFirstName());
			System.out.println(ofacDetail.getDetails().getEntityName());
			System.out.println(ofacDetail.getDetails().getProgram());
			

			System.out.println("alias:");
			for(OfacAlias alias :ofacDetail.getAliases()) {
				System.out.println(alias.getCategory());
			}
			
			System.out.println("identification:");
			for(OfacIdentification alias :ofacDetail.getIdentifications()) {
				System.out.println(alias.getId());
			}
			
			
			System.out.println("address:");
			for(OfacAddress address :ofacDetail.getAddresses()) {
				System.out.println(address.getAddress());
			}
			System.out.println(ofacDetail.getEndInMillis() - ofacDetail.getStartInMillis());
			
			
		}catch(Exception e) {
			
		}
		
	}

}
