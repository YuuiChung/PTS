package cn.nfu.pts.bean.impl;

import java.sql.Timestamp;

import cn.nfu.pts.bean.Filter;
import cn.nfu.pts.bean.UUID;

public class FilterImpl implements Filter
{
	private static final long serialVersionUID = 8205603190899467482L;
	private UUID id = null;
	private String name = null;
	private String createUser = null;
	private Timestamp createTime = null;
	private boolean isPublic = false;
	private boolean isForce = false;
	private boolean isAnd = false;
	private String xml = null;
	private UUID fatherId = null;
	private boolean isVisible = false;
	private boolean isValid = true;
	
	/**
	 * <h1> Title:</h1>
	 * <p> Description:init filter</p>
	 * @param id
	 * @param createUser
	 * @param createTime
	 * @param fatherId
	 */
	public FilterImpl(UUID id, String createUser, Timestamp createTime, UUID fatherId)
	{
		super();
		this.id = id;
		this.createUser = createUser;
		this.createTime = createTime;
		this.fatherId = fatherId;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Filter#getId()
	 */
	public UUID getId()
	{
		return id;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getName</p>
	 * @return
	 * @see cn.nfu.pts.bean.Filter#getName()
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getCreateUser</p>
	 * @return
	 * @see cn.nfu.pts.bean.Filter#getCreateUser()
	 */
	public String getCreateUser()
	{
		return createUser;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getCreateTime</p>
	 * @return
	 * @see cn.nfu.pts.bean.Filter#getCreateTime()
	 */
	public Timestamp getCreateTime()
	{
		return createTime;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:isPublic</p>
	 * @return
	 * @see cn.nfu.pts.bean.Filter#isPublic()
	 */
	public boolean isPublic()
	{
		return isPublic;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:isForce</p>
	 * @return
	 * @see cn.nfu.pts.bean.Filter#isForce()
	 */
	public boolean isForce()
	{
		return isForce;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:isAnd</p>
	 * @return
	 * @see cn.nfu.pts.bean.Filter#isAnd()
	 */
	public boolean isAnd()
	{
		return isAnd;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getXml</p>
	 * @return
	 * @see cn.nfu.pts.bean.Filter#getXml()
	 */
	public String getXml()
	{
		return xml;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getFatherId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Filter#getFatherId()
	 */
	public UUID getFatherId()
	{
		return fatherId;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setName</p>
	 * @param name
	 * @see cn.nfu.pts.bean.Filter#setName(java.lang.String)
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setPublic</p>
	 * @param isPublic
	 * @see cn.nfu.pts.bean.Filter#setPublic(boolean)
	 */
	public void setPublic(boolean isPublic)
	{
		this.isPublic = isPublic;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setForce</p>
	 * @param isForce
	 * @see cn.nfu.pts.bean.Filter#setForce(boolean)
	 */
	public void setForce(boolean isForce)
	{
		this.isForce = isForce;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setAnd</p>
	 * @param isAnd
	 * @see cn.nfu.pts.bean.Filter#setAnd(boolean)
	 */
	public void setAnd(boolean isAnd)
	{
		this.isAnd = isAnd;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setXml</p>
	 * @param xml
	 * @see cn.nfu.pts.bean.Filter#setXml(java.lang.String)
	 */
	public void setXml(String xml)
	{
		this.xml = xml;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:isVisible</p>
	 * @return
	 * @see cn.nfu.pts.bean.Filter#isVisible()
	 */
	public boolean isVisible()
	{
		return isVisible;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setVisible</p>
	 * @param isVisible
	 * @see cn.nfu.pts.bean.Filter#setVisible(boolean)
	 */
	public void setVisible(boolean isVisible)
	{
		this.isVisible = isVisible;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:isValid</p>
	 * @return
	 * @see cn.nfu.pts.bean.Filter#isValid()
	 */
	public boolean isValid()
	{
		return this.isValid;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setValid</p>
	 * @param isValid
	 * @see cn.nfu.pts.bean.Filter#setValid(boolean)
	 */
	public void setValid(boolean isValid)
	{
		this.isValid = isValid;
	}
}
