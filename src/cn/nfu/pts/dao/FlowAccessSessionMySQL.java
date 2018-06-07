package cn.nfu.pts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.w3c.dom.Document;

import cn.nfu.pts.bean.Flow;
import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.bean.impl.FlowImpl;
import cn.nfu.pts.service.DbPoolConnection;
import cn.nfu.pts.util.XMLUtil;


/**
 * @ClassName : FlowAccessSessionMySQL
 * @Description : 
 */
public class FlowAccessSessionMySQL {

	
	/**
	 * @description query a flow
	 * @param flowId
	 * */
	public Flow queryFlowById(UUID flowId)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Flow flow = null;
		try
		{
			conn = DbPoolConnection.getInstance().getReadConnection();
			String sql = "select * from flow where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, flowId.getValue());
			rs = pstm.executeQuery();
			if(rs.next())
			{
				String xml = rs.getString("xml");
				Document doc = XMLUtil.string2Document(xml, "UTF-8");
				flow = new FlowImpl(doc,rs.getString("create_user"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeResultSet(rs);
			DbPoolConnection.getInstance().closeStatment(pstm);
			DbPoolConnection.getInstance().closeConn(conn);
		}
	
		return flow;
	}
	
	/**
	 * @description:query all flows from db
	 * @version:v1.0
	 * @return
	 */
	public Vector<Flow> queryAllFlow()
	{
		Vector<Flow> flowList = new Vector<Flow>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try
		{
			conn = DbPoolConnection.getInstance().getReadConnection();
			
			String sql = "select create_user,  xml from flow where is_valid = ? order by name";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "1");
			
			rs = pstm.executeQuery();
			while(rs.next())
			{
				try {
					String xml = rs.getString("xml");
					String createUser = rs.getString("create_user");
					Document doc = XMLUtil.string2Document(xml, "UTF-8");
					Flow flow = new FlowImpl(doc,createUser);
					flowList.add(flow);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeResultSet(rs);
			DbPoolConnection.getInstance().closeStatment(pstm);
			DbPoolConnection.getInstance().closeConn(conn);
		}
		return flowList;
	}
	
	/**
	 * @description add a flow
	 * */
	public boolean addFlow(Flow flow)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "insert into flow(id,name,xml,create_user) values(?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, flow.getId().getValue());
			pstm.setString(2, XMLUtil.toSafeXMLString(flow.getName()));
			pstm.setString(3, flow.toXMLString());
			pstm.setString(4, flow.getCreateUser());
			if (pstm.executeUpdate() >0) {
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
			DbPoolConnection.getInstance().closeStatment(pstm);
			DbPoolConnection.getInstance().closeConn(conn);
		}
	}
	
	/**
	 * @description update a flow
	 * */
	public boolean updateFlow(Flow flow)
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "update flow set name = ?, xml = ? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, XMLUtil.toSafeXMLString(flow.getName()));
			pstm.setString(2, flow.toXMLString());
			pstm.setString(3, flow.getId().getValue());
			if (pstm.executeUpdate() >0) {
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
			DbPoolConnection.getInstance().closeStatment(pstm);
			DbPoolConnection.getInstance().closeConn(conn);
		}
	}
	
	/**
	 * @description delete a flow,set flow is_valid
	 * */
	public boolean removeFlowById(UUID flowId)
	{
		return setFlowValid(flowId, false);
	}
	
	/**
	 * @description:query all flow id and name map
	 * @version:v1.0
	 * @return
	 */
	public Map<String, String> queryIdName(){
		Map<String, String> idNameMap = new HashMap<String, String>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "select id,name from flow where is_valid=1";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next())
			{
				idNameMap.put(rs.getString("id"), rs.getString("name"));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
		return idNameMap;
	}
	
	
	/**
	 * @description:update flow isvalid
	 * @version:v1.0
	 * @param flowId
	 * @param isValid
	 * @return
	 */
	public boolean setFlowValid(UUID flowId, boolean isValid ){
		Connection conn = null;
		PreparedStatement pstm = null;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "update flow set is_valid = ? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, isValid ? "1" : "0");
			pstm.setString(2, flowId.getValue());
			return pstm.executeUpdate() >0 ; 
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
	 * @description:query flow svg
	 * @version:v1.0
	 * @param flowId
	 * @return
	 */
	public String querySvg(UUID flowId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String svgCode = "";
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "select svg_code from flow where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, flowId.getValue());
			rs = pstm.executeQuery();
			while(rs.next())
			{
				svgCode = rs.getString(1);
				break;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			DbPoolConnection.getInstance().closeAll(rs, pstm, conn);
		}
		return svgCode;
	}
	
	/**
	 * @description:update flow svg
	 * @version:v1.0
	 * @param flowId
	 * @param svgCode
	 * @return
	 */
	public boolean updateSvg(UUID flowId, String svgCode) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try
		{
			conn = DbPoolConnection.getInstance().getConnection();
			String sql = "update flow set svg_code = ?  where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, svgCode);
			pstm.setString(2, flowId.getValue());
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
}
