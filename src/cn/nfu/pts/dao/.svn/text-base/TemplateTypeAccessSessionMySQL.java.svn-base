package cn.nfu.pts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.nfu.pts.bean.TemplateType;
import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.bean.impl.TemplateTypeImpl;
import cn.nfu.pts.factory.DataAccessFactory;
import cn.nfu.pts.service.DbPoolConnection;


public class TemplateTypeAccessSessionMySQL {

	/**
	 * @description : add a template type
	 * @parm
	 */
	public boolean addTemplateType(TemplateType templateType)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "insert into template_type (name,description,displayIndex) values (?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, templateType.getName());
			pstm.setString(2, templateType.getDescription());
			pstm.setInt(3, templateType.getDisplayIndex());
			if (pstm.executeUpdate()>0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}finally
		{
			DbPoolConnection.getInstance().closeAll(pstm, conn);
		}
	}

	/**
	 * @description : query template from database
	 * @parm : templateId
	 */
	public TemplateType queryTemplateTypeById(UUID templateTypeId)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try
		{
			conn = DbPoolConnection.getInstance().getReadConnection();
			String sql = "select * from template_type where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, Integer.parseInt(templateTypeId.getValue()));
			rs = pstm.executeQuery();
			TemplateType templateType = null;
			if(rs.next())
			{
				templateType = new TemplateTypeImpl();
				templateType.setId(DataAccessFactory.getInstance().createUUID(Integer.toString(rs.getInt("id"))));
				templateType.setName(rs.getString("name"));
				templateType.setDisplayIndex(rs.getInt("displayIndex"));
			}
			return templateType;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
	}

	/**
	 * @description : query all templateType from database
	 * @parm : templateId
	 */
	public List<TemplateType> queryAllTemplateType()
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<TemplateType> templateTypeList = new ArrayList<TemplateType>();
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "select * from template_type";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next())
			{
				TemplateType templateType = new TemplateTypeImpl();
				templateType.setId(DataAccessFactory.getInstance().createUUID(Integer.toString(rs.getInt("id"))));
				templateType.setName(rs.getString("name"));
				templateType.setDisplayIndex(rs.getInt("displayIndex"));
				templateTypeList.add(templateType);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
		return templateTypeList;
	}
}
