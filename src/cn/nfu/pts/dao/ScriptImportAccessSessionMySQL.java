package cn.nfu.pts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.nfu.pts.service.DbPoolConnection;

public class ScriptImportAccessSessionMySQL {

	/**
	 * @description:modify script import 
	 * @version:v1.0
	 * @param importStr
	 * @return
	 */
	public boolean modify(String importStr)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "update from script_import set import_str = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, importStr);
			return pstm.executeUpdate() > 0;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}finally
		{
			DbPoolConnection.getInstance().closeStatment(pstm);
			DbPoolConnection.getInstance().closeConn(conn);
		}
	}
	
	/**
	 * @description:query import info
	 * @version:v1.0
	 * @return
	 */
	public String query()
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String importStr = "";
		try
		{
			conn = DbPoolConnection.getInstance().getReadConnection();
			
			String sql = "select * from script_import";
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			while(rs.next())
			{
				importStr = rs.getString("import_str");
				break;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
		return importStr;
	}

}
