package net.hubs1.com.Enum;

public class JimasTest {

	public static void main(String[] args) {
		JimasEnum jimas=JimasEnum.Monday;
		JimasEnum nextDay = jimas.nextDay();
		System.out.println(nextDay);
		System.out.println(nextDay.name());
		
		DataEnum data=DataEnum.Two;
		System.out.println(data.getValue());
		System.out.println(data.getCode());
		System.out.println(DataEnum.getValuesByCode("one"));
	}

}
