package cn.nfu.pts.bean.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import cn.nfu.pts.bean.ChangeLog;
import cn.nfu.pts.bean.Pair;
import cn.nfu.pts.bean.UUID;

public final class ChangeLogImpl implements ChangeLog
{
	/**
	 * @Fields:serialVersionUID
	 * @Fields_Type:long
	 * @description:TODO
	 */
	private static final long serialVersionUID = 4534150839520305469L;
	
	private UUID id = null;
	private String createUser = null;
	private Timestamp createTime = null;
	private UUID actionId = null;
	private String actionComment = null;
	private Map<String, Pair<Object, Object>> baseValueMap = null;
	private Map<UUID, Pair<Object, Object>> extValueMap = null;
	
	/**
	 * 
	 * <h1> Title:</h1>
	 * <p> Description:init change log</p>
	 * @param id
	 * @param createUser
	 * @param createTime
	 * @param actionId
	 * @param actionComment
	 * @param baseValueMap
	 * @param extValueMap
	 */
	public ChangeLogImpl(UUID id, String createUser, Timestamp createTime, UUID actionId, String actionComment,
			Map<String, Pair<Object, Object>> baseValueMap, Map<UUID, Pair<Object, Object>> extValueMap)
	{
		super();
		
		this.id = id;
		this.createUser = createUser;
		this.createTime = createTime;
		this.actionId = actionId;
		this.actionComment = actionComment;
		this.baseValueMap = baseValueMap;
		this.extValueMap = extValueMap;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getId</p>
	 * @return
	 * @see cn.nfu.pts.bean.ChangeLog#getId()
	 */
	public UUID getId()
	{
		return id;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getCreateUser</p>
	 * @return
	 * @see cn.nfu.pts.bean.ChangeLog#getCreateUser()
	 */
	public String getCreateUser()
	{
		return createUser;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getCreateTime</p>
	 * @return
	 * @see cn.nfu.pts.bean.ChangeLog#getCreateTime()
	 */
	public Timestamp getCreateTime()
	{
		return createTime;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getActionId</p>
	 * @return
	 * @see cn.nfu.pts.bean.ChangeLog#getActionId()
	 */
	public UUID getActionId()
	{
		return actionId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getActionComment</p>
	 * @return
	 * @see cn.nfu.pts.bean.ChangeLog#getActionComment()
	 */
	public String getActionComment()
	{
		return actionComment;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setActionComment</p>
	 * @param actionComment
	 * @see cn.nfu.pts.bean.ChangeLog#setActionComment(java.lang.String)
	 */
	public void setActionComment(String actionComment){
		this.actionComment = actionComment;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getBaseValueMap</p>
	 * @return
	 * @see cn.nfu.pts.bean.ChangeLog#getBaseValueMap()
	 */
	public Map<String, Pair<Object, Object>> getBaseValueMap()
	{
		if(baseValueMap == null){
			return new HashMap<String, Pair<Object, Object>>();
		}
		
		return baseValueMap;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getExtValueMap</p>
	 * @return
	 * @see cn.nfu.pts.bean.ChangeLog#getExtValueMap()
	 */
	public Map<UUID, Pair<Object, Object>> getExtValueMap()
	{
		if(extValueMap == null){
			return new HashMap<UUID, Pair<Object, Object>>();
		}
		
		return extValueMap;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getObject</p>
	 * @param name
	 * @return
	 * @see cn.nfu.pts.bean.ChangeLog#getObject(java.lang.String)
	 */
	public Object getObject(String name)
	{
		if(this.baseValueMap == null)
			return null;
		
		Pair<Object, Object> value = this.baseValueMap.get(name);
		if(value == null)
			return null;
		
		return value.getSecond();
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getObject</p>
	 * @param id
	 * @return
	 * @see cn.nfu.pts.bean.ChangeLog#getObject(cn.nfu.pts.bean.UUID)
	 */
	public Object getObject(UUID id)
	{
		if(this.extValueMap == null)
			return null;
		
		Pair<Object, Object> value = this.extValueMap.get(id);
		if(value == null)
			return null;
		
		return value.getSecond();
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:containsObject</p>
	 * @param name
	 * @return
	 * @see cn.nfu.pts.bean.ChangeLog#containsObject(java.lang.String)
	 */
	public boolean containsObject(String name)
	{
		if(baseValueMap == null)
			return false;
		
		return baseValueMap.containsKey(name);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:containsObject</p>
	 * @param id
	 * @return
	 * @see cn.nfu.pts.bean.ChangeLog#containsObject(cn.nfu.pts.bean.UUID)
	 */
	public boolean containsObject(UUID id)
	{
		if(extValueMap == null)
			return false;
		
		return extValueMap.containsKey(id);
	}

}
