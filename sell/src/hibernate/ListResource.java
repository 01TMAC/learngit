package hibernate;

import java.util.List;
import java.util.Map;

/**
 * 用于处理存储数据库查询获取的数据
 * 转换成的list列表
 * @author mailian
 *
 */
public class ListResource {
	//用于存储数据库的多行数据
	private List dataList;
	//用于存储单行数据
	private MapResource mapResource;
	
	//获取查询数据的某行数据返回封装成MapResource类型
	public MapResource getRow(int num)
	{
		MapResource mapResource = new MapResource();
		mapResource.setDataMap((Map)dataList.get(num));
		return mapResource;
	}


	public List getDataList() {
		return dataList;
	}


	public void setDataList(List dataList) {
		this.dataList = dataList;
	}


	public MapResource getMapResource() {
		return mapResource;
	}


	public void setMapResource(MapResource mapResource) {
		this.mapResource = mapResource;
	}

	
}
