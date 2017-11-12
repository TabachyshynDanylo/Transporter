package ua.model.filter;

import java.util.regex.Pattern;

public class OwnerFilter {
	
	private static final Pattern INT_PATTERN = Pattern.compile("^[0-9]{1,10}$");
	
	private String minCount = "";
	
	private String maxCount  = "";
	
	private String address = "";

	public String getMinCount() {
		return minCount;
	}

	public void setMinCount(String minCount) {
		if(INT_PATTERN.matcher(minCount).matches())
		this.minCount = minCount;
	}

	public String getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(String maxCount) {
		if(INT_PATTERN.matcher(maxCount).matches())
		this.maxCount = maxCount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}