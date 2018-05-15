package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

import net.sf.json.JSON;



public class Test {

	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("15052011", 2);
		map.put("15052012", 2);
		map.put("15052013", 2);
		map.put("15052014", 2);
		System.out.println("-----15052011"+map);
		List list = new ArrayList();
		list.add(map);
		System.out.println("mapList:"+list);
		String listStr = JSONObject.valueToString(list);
		net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(listStr);
		/*
		System.out.println("------------");
		JSONObject goodslist=(JSONObject) JSONObject.wrap(map);
		System.out.println("pre_goodslist:"+goodslist);
		String str=JSONObject.valueToString(goodslist);
		System.out.println("pre_goodslist_string:"+str);
		
		net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(str);
		List mapList = (List)net.sf.json.JSONArray.toList(jsonArray);
		
		System.out.println("------15052011:"+mapList.get(0));
		System.out.println("mapList:"+mapList);
		 Iterator ite = jsonObject.keys();
		 while(ite.hasNext())
		 {
			 System.out.print("key:"+ite.next());
			 System.out.print("value:"+(int)jsonObject.get(ite.next()));
			 System.out.println();
		 }
		
		
		
		
//		 JSONObject jsonObject2 = JSONObject.fromObject(map);
//		List list = (List)jsonObject;
		
		
//		System.out.println("aft_jo"+jsonObject);
		System.out.println("-------------");
//		String a=goodslist.getLong(15052011);
		
//		System.out.println(a);
//		System.out.println(goodslist);
//		String str=JSONObject.valueToString(goodslist);
//		for(Object obj:goodslist.keySet()){
//			long a=Long.parseLong(obj.toString());
//			int a=(int) goodslist.getInt(obj.toString());
//			String a=goodslist.getString("15052011");
//			
//			System.out.println(a);
//			
//		}
//		Iterator<String> sIterator = goodslist.keys();  
//		while(sIterator.hasNext()){  
//		    // 获得key  
//		    String key = (sIterator.next()).toString();  
//		    // 根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可  
//		    int value = goodslist.getInt(key);  
//		    System.out.println("key: "+key+",value"+value);  
//		}  
//		System.out.println(str);*/
//		
	}

}

