package org.istqb.bo;

import org.json.JSONArray;


public class JSONAdapter {

	private String jsonObjectString;
	private JSONArray supi;

	
	public JSONAdapter() {
		JSONArray jArray1 = new JSONArray();
		jArray1.put(new String("d6"));
		jArray1.put(new Integer(0));
		jArray1.put(new Integer(1));
		jArray1.put(new String(""));
		jArray1.put(new String(""));

		JSONArray jArray2 = new JSONArray();
		jArray2.put(new String("d6"));
		jArray2.put(new Integer(6));
		jArray2.put(new Integer(2));
		jArray2.put(new String("green"));
		jArray2.put(new String("Grüen"));

		JSONArray jArray3 = new JSONArray();
		jArray3.put(new String("d6"));
		jArray3.put(new Integer(7));
		jArray3.put(new Integer(2));
		jArray3.put(new String("orange"));
		jArray3.put(new String("Orangsch"));

		
		
		supi = new JSONArray();
		supi.put(jArray1);
		//supi.put(jArray2);
		//supi.put(jArray3);
	    jsonObjectString = supi.toString();
	    //jsonObjectString = "";
	}

	
	
	public String getJsonObjectString() {
	    return jsonObjectString;
	}
	public JSONArray getJsonArray() {
		return supi;
	}
	public void setJsonObjectString(String aParameter) {
		jsonObjectString = aParameter;
	}
	
}
