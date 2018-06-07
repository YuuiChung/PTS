package cn.nfu.pts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.nfu.pts.bean.TagBean;
import cn.nfu.pts.service.DbPoolConnection;

public class TagAccessSessionMySQL {

	/**
	 * @description:get all tags
	 * @version:v1.0
	 * @param userName
	 * @return
	 */
	public List<TagBean> getAllTag(String userName)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<TagBean> allTagList = new ArrayList<TagBean>();
		try{
			conn = DbPoolConnection.getInstance().getReadConnection();
			String sql = "select * from tag where user_name=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userName);
			rs = pstm.executeQuery();

			while(rs.next()){
				TagBean tb = new TagBean();
				tb.setId(rs.getString("id"));
				tb.setTagName(rs.getString("name"));
				tb.setCreateUsers(rs.getString("user_name"));
				tb.setTagColor(rs.getString("color"));
				allTagList.add(tb);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
		return allTagList;
	}
	
	/**
	 * @description:get datas of tag
	 * @version:v1.0
	 * @param tagId
	 * @return
	 */
	public String[] getTagDataById( String tagId)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<String> tagDataList = new ArrayList<String>();
		try{
			conn = DbPoolConnection.getInstance().getReadConnection();
			String sql = "select tag_data from tag_data where tag_id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, tagId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				tagDataList.add(rs.getString("tag_data"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
		return tagDataList.toArray( new String[0]);
	}
	
	/**
	 * @description:add data to tag
	 * @version:v1.0
	 * @param tagId
	 * @param dataIds
	 * @return
	 */
	public boolean addTagData(String tagId , String[] dataIds)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			
			conn = DbPoolConnection.getInstance().getConnection();
			
			pstmt = conn.prepareStatement("insert ignore into tag_data (tag_id,tag_data) values (?,?)");
			for (String dataId : dataIds) {
				pstmt.setString(1, tagId);
				pstmt.setString(2, dataId);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstmt, conn);
		}
	}
	
	/**
	 * @description:delete tag data by data id
	 * @version:v1.0
	 * @param dataId
	 * @return
	 */
	public boolean deleteTagData(String dataId)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			
			conn = DbPoolConnection.getInstance().getConnection();
			pstmt = conn.prepareStatement("delete from tag_data where tag_data= ?");
			pstmt.setString(1, dataId);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstmt, conn);
		}
	}
	
	/**
	 * @description:delete tag data by data ids
	 * @version:v1.0
	 * @param tagId
	 * @param dataIds
	 * @return
	 */
	public boolean deleteTagData(String tagId , String[] dataIds)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DbPoolConnection.getInstance().getConnection();
			if (tagId != null && tagId.length() > 0) {
				//删除标签下数据
				pstmt = conn.prepareStatement("delete from tag_data where tag_id = ? and tag_data= ?");
				for (String dataId : dataIds) {
					pstmt.setString(1, tagId);
					pstmt.setString(2, dataId);
					pstmt.addBatch();
				}
				pstmt.executeBatch();
			}else {
				//删除数据的所有标签
				pstmt = conn.prepareStatement("delete from tag_data where tag_data= ?");
				for (String dataId : dataIds) {
					pstmt.setString(1, dataId);
					pstmt.addBatch();
				}
				pstmt.executeBatch();
			}
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstmt, conn);
		}
	}
	
	/**
	 * @description:add tag to db
	 * @version:v1.0
	 * @param userName
	 * @param tagName
	 * @param tagColor
	 * @return
	 */
	public int addTag(String userName , String tagName , String tagColor)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int result = 0;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "insert into tag (name,user_name,color) values (?,?,?)";
			pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, tagName);
			pstm.setString(2, userName);
			pstm.setString(3, tagColor);
			if(pstm.executeUpdate()>0)
			{
				rs = pstm.getGeneratedKeys();
				if(rs.next())
				{
					result = Integer.parseInt(rs.getString(1));
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}

		return result;
	}
	
	/**
	 * @description:update tag 
	 * @version:v1.0
	 * @param tagId
	 * @param tagName
	 * @param tagColor
	 * @return
	 */
	public boolean updateTag(String tagId,  String tagName,String tagColor)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "update tag set name = ? ,color= ? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, tagName);
			pstm.setString(2, tagColor);
			pstm.setString(3, tagId);
			return pstm.executeUpdate() > 0;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
	}
	
	/**
	 * @description:delete tag
	 * @version:v1.0
	 * @param tagId
	 * @return
	 */
	public boolean deleteTag(String tagId)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "delete from tag where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, tagId);
			pstm.executeUpdate();
			
			sql = "delete from tag_data where tag_id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, tagId);
			pstm.executeUpdate();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
	}


	/**
	 * @description:get all tag data map of user
	 * @version:v1.0
	 * @param userName
	 * @return:<tagid, tagdata split by ,>
	 */
	public Map<String, String> getUserTagDataMap(String userName) {
		Map<String, String> allTagDataMap = new HashMap<String, String>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try
		{
			conn = DbPoolConnection.getInstance().getReadConnection();
			String sql = "SELECT A.id , A.name,A.user_name ,B.tag_data,B.filter_id from tag as A LEFT JOIN " +
					"tag_data as B on A.id = B.tag_id where A.user_name=? order by B.tag_data";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userName);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				String curTagId = allTagDataMap.get(rs.getString("tag_data"));
				if (curTagId != null) {
					allTagDataMap.put(rs.getString("tag_data"), curTagId + "," + rs.getString("id"));
				}else {
					allTagDataMap.put(rs.getString("tag_data"), rs.getString("id"));
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
		return allTagDataMap;
	}

	/**
	 * @description:get all tags of user
	 * @version:v1.0
	 * @param userName
	 * @param dataId
	 * @return
	 */
	public List<TagBean> getDataTags(String userName, String dataId) {
		List<TagBean> allTagList = new ArrayList<TagBean>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "SELECT A.id , A.name,A.user_name ,A.color,B.tag_data,B.filter_id from tag as A LEFT JOIN " +
					"tag_data as B on A.id = B.tag_id where A.user_name=? and B.tag_data=? order by B.tag_data";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(2, dataId);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				TagBean tBean = new TagBean();
				tBean.setId(rs.getString("id"));
				tBean.setTagName(rs.getString("name"));
				tBean.setTagColor(rs.getString("color"));
				allTagList.add(tBean);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
		return allTagList;
	}
	
}
