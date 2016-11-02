package net.hubs1.com.Enum;

import org.springframework.util.StringUtils;

public enum DataEnum {
	One("1","one"),Two("2","two");
	
	private String value;
	private String code;
	DataEnum(String value,String code){
		this.value=value;
		this.code=code;
	}
	
	
	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public static String getValuesByCode(String code){
		if(StringUtils.isEmpty(code)) return null;
		for(DataEnum data:values()){
			if(data.getCode().equals(code)){
				return data.getValue();
			}
		}
		
		return null;
	}
}
