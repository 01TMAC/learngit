package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class RandomTest {
	public static void main(String[] args) { 
		  java.util.Random r=new java.util.Random(); 
		  SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
	        System.out.println(format.format(new Date()));
		for(int i=0;i<5;i++){ 
		    System.out.print(r.nextInt(10)); 
		} 
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		Long createTime = Long.parseLong(df.format(Calendar.getInstance().getTimeInMillis()));
		System.out.println("-------------:"+createTime);
		} 

}
