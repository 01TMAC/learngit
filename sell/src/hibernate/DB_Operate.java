package hibernate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 * 数据库操作接口
 * @author mailian
 *
 */
public interface DB_Operate {
	public ListResource execToList(String sql,List list) throws SQLException, ClassNotFoundException;
	public ListResource execToList(String sql) throws SQLException, ClassNotFoundException;
	public int insert(String sql,List list) throws SQLException, ClassNotFoundException;
	public int delete(String sql,List list) throws SQLException, ClassNotFoundException;
	public int update(String sql,List list) throws SQLException, ClassNotFoundException;
}
