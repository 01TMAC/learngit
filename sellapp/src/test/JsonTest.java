package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import goods.Goods;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
public class JsonTest {
	public static void main(String [] args)
	{
		List goodsList = new ArrayList();
		Goods goods = new Goods(12, 1, "kele", 1, 11, 2.5);
		goodsList.add(goods);
		goodsList.add(goods);
		JSONArray jsonArray = JSONArray.fromObject(goodsList);  
        System.out.println(jsonArray.toString()); 
        List list2 = JSONArray.toList(jsonArray, new Goods(), new JsonConfig());  
        Iterator ite =  list2.iterator();  
        while(ite.hasNext()){  
            Goods goods1 =(Goods) ite.next();  
            System.out.println(goods1.getName());  
        }  
	/*	Map<String,Integer> map = new HashMap<String,Integer>();  
        map.put("1",2);  
        map.put("2",2);  
        map.put("3",2); 
        net.sf.json.JSONObject jsonMap = net.sf.json.JSONObject.fromObject(map);
        String listStr = JSONObject.valueToString(jsonMap);
        System.out.println(GetType.getType(listStr));
	//	String json="{\"1\":2,\"2\":2,\"3\":2}";
        Map<String,Integer> map1=net.sf.json.JSONObject.fromObject(listStr);
        Set set = map1.keySet();  
        Iterator ite = set.iterator();  
	      while (ite.hasNext()) {  
	          String key = (String) ite.next();  
	          System.out.println(GetType.getType(map1.get(key)));
	          System.out.println(key + " " + map1.get(key));  
	      }  */
	}

}
