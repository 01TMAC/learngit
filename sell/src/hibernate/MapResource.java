package hibernate;

import java.util.Map;
/**
 * ���ڴ����ȡlist�б�ĵ�������
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
	//��ȡ�������ݵ�ָ���ֶε�ֵ
	public Object getColValue(String name)
	{
		return dataMap.get(name);
	}
	
}
