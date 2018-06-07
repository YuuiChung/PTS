package cn.nfu.pts.bean.impl;

import org.w3c.dom.Document;

import cn.nfu.pts.bean.Option;
import cn.nfu.pts.bean.UUID;

public class OptionImpl implements Option
{
	/**
	 * @Fields:serialVersionUID
	 * @Fields_Type:long
	 * @description:TODO
	 */
	private static final long serialVersionUID = 3861219905584902915L;

	private UUID id = null;

	private UUID fieldId = null;

	private UUID controlOptionId = null;

	private UUID fatherOptionId = null;

	private Forbidden forbidden = Forbidden.f_permit;

	private int indexOrder = 0;

	private String name = null;

	private String description = null;

	/**
	 * <h1> Title:</h1>
	 * <p> Description: init option</p>
	 * @param id
	 * @param fieldId
	 */
	public OptionImpl(UUID id, UUID fieldId)
	{
		this.id = id;
		this.fieldId = fieldId;
	}
	
	public OptionImpl(UUID id, UUID fieldId, String name)
	{
		this.id = id;
		this.fieldId = fieldId;
		this.name = name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:clone</p>
	 * @return
	 * @see java.lang.Object#clone()
	 */
	public Option clone()
	{
		OptionImpl optionImpl = new OptionImpl(this.id, this.fieldId);

		optionImpl.controlOptionId = controlOptionId;
		optionImpl.fatherOptionId = fatherOptionId;
		optionImpl.forbidden = forbidden;
		optionImpl.indexOrder = indexOrder;
		optionImpl.name = name;
		optionImpl.description = description;

		return optionImpl;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getControlOptionId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Option#getControlOptionId()
	 */
	public UUID getControlOptionId()
	{
		return this.controlOptionId;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setControlOptionId</p>
	 * @param controlOptionId
	 * @see cn.nfu.pts.bean.Option#setControlOptionId(cn.nfu.pts.bean.UUID)
	 */
	public void setControlOptionId(UUID controlOptionId)
	{
		this.controlOptionId = controlOptionId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getFatherOptionId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Option#getFatherOptionId()
	 */
	public UUID getFatherOptionId()
	{
		return this.fatherOptionId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setFatherOptionId</p>
	 * @param fatherOptionId
	 * @see cn.nfu.pts.bean.Option#setFatherOptionId(cn.nfu.pts.bean.UUID)
	 */
	public void setFatherOptionId(UUID fatherOptionId)
	{
		this.fatherOptionId = fatherOptionId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getFieldId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Option#getFieldId()
	 */
	public UUID getFieldId()
	{
		return this.fieldId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Option#getId()
	 */
	public UUID getId()
	{
		return this.id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getName</p>
	 * @return
	 * @see cn.nfu.pts.bean.Option#getName()
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getForbidden</p>
	 * @return
	 * @see cn.nfu.pts.bean.Option#getForbidden()
	 */
	public Forbidden getForbidden()
	{
		return this.forbidden;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setForbidden</p>
	 * @param forbidden
	 * @see cn.nfu.pts.bean.Option#setForbidden(cn.nfu.pts.bean.Option.Forbidden)
	 */
	public void setForbidden(Forbidden forbidden)
	{
		this.forbidden = forbidden;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getIndexOrder</p>
	 * @return
	 * @see cn.nfu.pts.bean.Option#getIndexOrder()
	 */
	public int getIndexOrder()
	{
		return this.indexOrder;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setIndexOrder</p>
	 * @param indexOrder
	 * @see cn.nfu.pts.bean.Option#setIndexOrder(int)
	 */
	public void setIndexOrder(int indexOrder)
	{
		this.indexOrder = indexOrder;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getDescription</p>
	 * @return
	 * @see cn.nfu.pts.bean.Option#getDescription()
	 */
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setDescription</p>
	 * @param description
	 * @see cn.nfu.pts.bean.Option#setDescription(java.lang.String)
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setName</p>
	 * @param name
	 * @see cn.nfu.pts.bean.Option#setName(java.lang.String)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @description:TODO
	 * @version:v1.0
	 * @return
	 * @throws Exception
	 */
	public Document toXMLDocument() throws Exception
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:toXMLString</p>
	 * @return
	 * @see cn.nfu.pts.bean.Option#toXMLString()
	 */
	public String toXMLString()
	{
		throw new UnsupportedOperationException();
	}
}
