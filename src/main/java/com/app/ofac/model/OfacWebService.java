package com.app.ofac.model;

import java.util.ArrayList;

public class OfacWebService {
	 private boolean error;
	  ArrayList<OfacWebServiceApplication> matches = new ArrayList<OfacWebServiceApplication>();
	 // Getter Methods 

	  public boolean isError() {
	    return error;
	  }

	 // Setter Methods 

	  public void setError( boolean error ) {
	    this.error = error;
	  }

	public ArrayList<OfacWebServiceApplication> getMatches() {
		return matches;
	}

	public void setMatches(ArrayList<OfacWebServiceApplication> matches) {
		this.matches = matches;
	}
	  
}
