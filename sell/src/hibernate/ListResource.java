package hibernate;

import java.util.List;
import java.util.Map;

/**
 * ���ڴ���洢���ݿ��ѯ��ȡ������
 * ת���ɵ�list�б�
 * @author mailian
 *
 */
public class ListResource {
	//���ڴ洢���ݿ�Ķ�������
	private List dataList;
	//���ڴ洢��������
	private MapResource mapResource;
	
	//��ȡ��ѯ���ݵ�ĳ�����ݷ��ط�װ��MapResource����
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
