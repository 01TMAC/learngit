package hibernate;

import java.util.Map;
/**
 * 用于处理获取list列表的单行数据
 * @author mailian
 *
 */
public class MapResource {
	private Map dataMap;
	
	public Map getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map dataMap) {
		this.dataMap = dataMap;
	}
	//获取单行数据的指定字段的值
	public Object getColValue(String name)
	{
		return dataMap.get(name);
	}
	
}
