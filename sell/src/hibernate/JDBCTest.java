package hibernate;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
/**
 * ≤‚ ‘”√
 * @author mailian
 *
 */

public class JDBCTest {
	
	
	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
//	 */
	public static void main(String [] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException 
	{
	
		DB_Operate dboperate = new JDBCUtils();
		List list = new ArrayList();
		int num = 2;
		JSONObject jo= new JSONObject();
		System.out.println(GetType.getType(jo));
		String userName = "fuck";
		list.add(num);
		
	    System.out.println("1:"+dboperate.execToList("select * from sell_goods where id=? ",list).getDataList().size());
	    System.out.println("2:"+dboperate.execToList("select * from sell_user "));	    
	}

}
