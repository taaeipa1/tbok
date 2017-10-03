package org.istqb.beans;

public class DomainList {
	    
	    java.util.List<String> list = new java.util.ArrayList<String>();
	    
	    public DomainList(){
			
		}
	
	    public java.util.List<String> getItems(String aValue) {
	        
	        
	        if (aValue.equals("Source")) {
	        	list.add("CTFL");
	        	list.add("FA");
	        	list.add("ALTM");
	        	list.add("ALTA");
	        	list.add("ALTTA");
	        	list.add("UX");
	        }
	        if (aValue.equals("Language")) {
	        	list.add("English");
	        	list.add("German");
	        	list.add("French");
	        }
	        
	        if (aValue.equals("Klevel")) {
	        	list.add("K1");
	        	list.add("K2");
	        	list.add("K3");
	        	list.add("K4");
	        	list.add("K5");
	        	list.add("K6");
	        	list.add("K7");
	        }
	        
	        return list;
	    }
	    
	    public java.util.List<String> getCurrentItems() {
	        return list;
	    }
	    
	
}
