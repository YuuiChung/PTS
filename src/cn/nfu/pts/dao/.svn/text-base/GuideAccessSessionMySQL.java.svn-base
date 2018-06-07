package cn.nfu.pts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.nfu.pts.bean.GuideBean;
import cn.nfu.pts.service.DbPoolConnection;

public class GuideAccessSessionMySQL {

	/**
	 * @description:查询所有
	 * @version:v1.0
	 * @return
	 */
	public List<GuideBean> getAll()
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<GuideBean> all = new ArrayList<GuideBean>();
		try{
			conn = DbPoolConnection.getInstance().getReadConnection();
			String sql = "select * from guide where isDeleted = 0 order by id";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while(rs.next()){
				GuideBean guideBean = new GuideBean();
				guideBean.setId(rs.getInt("id"));
				guideBean.setGuideId(rs.getString("guide_id"));
				guideBean.setGuideName(rs.getString("guide_name"));
				guideBean.setParentId(rs.getInt("parent_id"));
				guideBean.setDeleted(rs.getBoolean("isDeleted"));
				all.add(guideBean);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
		return all;
	}
	
	/**
	 * @description:根据GuideId查询
	 * @version:v1.0
	 * @param guideId
	 * @return
	 */
	public String getGuideHtmlByGuideId( String guideId)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			conn = DbPoolConnection.getInstance().getReadConnection();
			String sql = "select guide_html from guide where guide_id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, guideId);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return rs.getString("guide_html");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
		return "";
	}
	
	/**
	 * @description:修改
	 * @version:v1.0
	 * @param guideId
	 * @param guideHtml
	 * @return
	 */
	public boolean saveGuideHtml(String guideId , String guideHtml)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DbPoolConnection.getInstance().getConnection();
			
			pstmt = conn.prepareStatement("update guide set guide_html = ? where guide_id = ?");
			pstmt.setString(1, guideHtml);
			pstmt.setString(2, guideId);
			return pstmt.executeUpdate() > 0;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstmt, conn);
		}
	}
	
}
