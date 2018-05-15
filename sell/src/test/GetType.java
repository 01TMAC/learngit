package test;
/**
 * 获取传入数据类型
 * @author mailian
 *
 */

public class GetType {
	public static String getType(Object o){
		String str = o.getClass().toString();
		str = str.replace("class java.lang.", "");
		return str;	
		}
		public static String getType(int o){
		return "int";
		}
		public static String getType(byte o){
		return "byte";
		}
		public static String getType(char o){
		return "char";
		}
		public static String getType(double o){
		return "double";
		}
		public static String getType(float o){
		return "float";
		}
		public static String getType(long o){
		return "long";
		}
		public static String getType(boolean o){
		return "boolean";
		}
		public static String getType(short o){
		return "short";
		}
}
