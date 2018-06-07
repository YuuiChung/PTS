package cn.nfu.pts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.apache.log4j.Logger;

import cn.nfu.pts.bean.TemplateOperateLog;
import cn.nfu.pts.service.DbPoolConnection;

public class TemplateLogAccessSessionMySQL {

private static Logger logger = Logger.getLogger(TemplateLogAccessSessionMySQL.class.getName());

	/**
	 * @description:add template operate log
	 * @version:v1.0
	 * @param templateOperateLog
	 * @return
	 */
	public boolean addTemplateAccessLog(TemplateOperateLog templateOperateLog)
	{
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstm = null;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "insert into template_operate_log (template_id,field_id,field_name,operate_type,create_time,create_user,before_xml,after_xml) values (?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, templateOperateLog.getTemplateId());
			pstm.setString(2, templateOperateLog.getFieldId());
			pstm.setString(3, templateOperateLog.getFieldName());
			pstm.setString(4, templateOperateLog.getOperateType());
			pstm.setString(5, templateOperateLog.getCreateTime().toString());
			pstm.setString(6, templateOperateLog.getCreateUser());
			pstm.setString(7, templateOperateLog.getBefore());
			pstm.setString(8, templateOperateLog.getAfter());
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
}
