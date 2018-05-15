package hibernate;
/**
 * 用于判断参数的类型
 * @author mailian
 *
 */

public class GetType {
	
		public static String getType(Object o){
		String str = o.getClass().toString();
		str = str.replace("class java.lang.", "");
		return str;	
		}
}
