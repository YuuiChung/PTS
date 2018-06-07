package cn.nfu.pts.bean.impl;

import java.sql.Timestamp;

import cn.nfu.pts.bean.Attachment;
import cn.nfu.pts.bean.UUID;

public class AttachmentImpl implements Attachment
{

	/**
	 * @Fields:serialVersionUID
	 * @Fields_Type:long
	 * @description:TODO
	 */
	private static final long serialVersionUID = 850580911571099515L;

	private UUID id = null;

	private long size = 0;

	private byte[] data = null;

	private String name = null;

	private String createUser = null;
	
	private String fileId = null;

	private Timestamp createTime = null;

	public AttachmentImpl(UUID id)
	{
		super();

		this.id = id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getCreateTime</p>
	 * @return
	 * @see cn.nfu.pts.bean.Attachment#getCreateTime()
	 */
	public Timestamp getCreateTime()
	{
		return createTime;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setCreateTime</p>
	 * @param createTime
	 * @see cn.nfu.pts.bean.Attachment#setCreateTime(java.sql.Timestamp)
	 */
	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getCreateUser</p>
	 * @return
	 * @see cn.nfu.pts.bean.Attachment#getCreateUser()
	 */
	public String getCreateUser()
	{
		return createUser;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setCreateUser</p>
	 * @param createUser
	 * @see cn.nfu.pts.bean.Attachment#setCreateUser(java.lang.String)
	 */
	public void setCreateUser(String createUser)
	{
		this.createUser = createUser;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Attachment#getId()
	 */
	public UUID getId()
	{
		return id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getSize</p>
	 * @return
	 * @see cn.nfu.pts.bean.Attachment#getSize()
	 */
	public long getSize()
	{
		return size;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setSize</p>
	 * @param size
	 * @see cn.nfu.pts.bean.Attachment#setSize(long)
	 */
	public void setSize(long size)
	{
		this.size = size;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getName</p>
	 * @return
	 * @see cn.nfu.pts.bean.Attachment#getName()
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setName</p>
	 * @param name
	 * @see cn.nfu.pts.bean.Attachment#setName(java.lang.String)
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getFileId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Attachment#getFileId()
	 */
	@Override
	public String getFileId() {
		return this.fileId;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setFileId</p>
	 * @param fileId
	 * @see cn.nfu.pts.bean.Attachment#setFileId(java.lang.String)
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getData</p>
	 * @return
	 * @see cn.nfu.pts.bean.Attachment#getData()
	 */
	public byte[] getData()
	{
		return data;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setData</p>
	 * @param content
	 * @see cn.nfu.pts.bean.Attachment#setData(byte[])
	 */
	public void setData(byte[] content)
	{
		this.data = content;
	}
}
