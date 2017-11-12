package ua.model.filter;

import java.util.regex.Pattern;

public class CargoFilter {
	
	private static final Pattern INT_PATTERN = Pattern.compile("^[0-9]{1,10}$");
	
	private static final Pattern DECIMAL_PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})|([0-9]{1,18})$");
	
	private String minWeight = "";
	
	private String maxWeight = "";
	
	private String minHeight = "";
	
	private String maxHeight = "";
	
	private String minWidth = "";
	
	private String maxWidth = "";
	
	private String minLength = "";
	
	private String maxLength = "";
	
	private String cityFrom = "";
	
	private String cityTo = "";
	
	private String minPrice = "";
	
	private String maxPrice = "";

	public String getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(String minWeight) {
		if(INT_PATTERN.matcher(minWeight).matches())
		this.minWeight = minWeight;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		if(INT_PATTERN.matcher(maxWeight).matches())
		this.maxWeight = maxWeight;
	}

	public String getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(String minHeight) {
		if(INT_PATTERN.matcher(minHeight).matches())
		this.minHeight = minHeight;
	}

	public String getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(String maxHeight) {
		if(INT_PATTERN.matcher(maxHeight).matches())
		this.maxHeight = maxHeight;
	}

	public String getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(String minWidth) {
		if(INT_PATTERN.matcher(minWidth).matches())
		this.minWidth = minWidth;
	}

	public String getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(String maxWidth) {
		if(INT_PATTERN.matcher(maxWidth).matches())
		this.maxWidth = maxWidth;
	}

	public String getMinLength() {
		return minLength;
	}

	public void setMinLength(String minLength) {
		if(INT_PATTERN.matcher(minLength).matches())
		this.minLength = minLength;
	}

	public String getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(String maxLength) {
		if(INT_PATTERN.matcher(maxLength).matches())
		this.maxLength = maxLength;
	}

	public String getCityFrom() {
		return cityFrom;
	}

	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}

	public String getCityTo() {
		return cityTo;
	}

	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if(DECIMAL_PATTERN.matcher(minPrice).matches())
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if(DECIMAL_PATTERN.matcher(maxPrice).matches())
		this.maxPrice = maxPrice;
	}
	

}