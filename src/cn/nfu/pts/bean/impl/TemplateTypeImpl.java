package cn.nfu.pts.bean.impl;

import org.w3c.dom.Document;

import cn.nfu.pts.bean.TemplateType;
import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.util.XMLUtil;


public class TemplateTypeImpl implements TemplateType
{
	/**
	 * @Fields:serialVersionUID
	 * @Fields_Type:long
	 * @description:TODO
	 */
	private static final long serialVersionUID = 5813622550811870889L;
	
	private UUID id = null;
	private String name = null;
	private String description = null;
	private int displayIndex = 0;

	public TemplateTypeImpl(){

	}

	/**
	 * <h1> Title:</h1>
	 * <p> Description:init template type</p>
	 * @param id
	 */
	public TemplateTypeImpl(UUID id)
	{
		this.id = id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:clone</p>
	 * @return
	 * @see java.lang.Object#clone()
	 */
	public TemplateType clone()
	{
		TemplateTypeImpl templateTypeImpl = new TemplateTypeImpl(this.id);
		templateTypeImpl.name = this.name;
		templateTypeImpl.description = this.description;
		templateTypeImpl.displayIndex = this.displayIndex;

		return templateTypeImpl;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getName</p>
	 * @return
	 * @see cn.nfu.pts.bean.TemplateType#getName()
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setId</p>
	 * @param id
	 * @see cn.nfu.pts.bean.TemplateType#setId(cn.nfu.pts.bean.UUID)
	 */
	@Override
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getId</p>
	 * @return
	 * @see cn.nfu.pts.bean.TemplateType#getId()
	 */
	public UUID getId()
	{
		return this.id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getDescription</p>
	 * @return
	 * @see cn.nfu.pts.bean.TemplateType#getDescription()
	 */
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getDisplayIndex</p>
	 * @return
	 * @see cn.nfu.pts.bean.TemplateType#getDisplayIndex()
	 */
	public int getDisplayIndex()
	{
		return this.displayIndex;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setDescription</p>
	 * @param description
	 * @see cn.nfu.pts.bean.TemplateType#setDescription(java.lang.String)
	 */
	public void setDescription(String description){
		this.description = description;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setDisplayIndex</p>
	 * @param displayIndex
	 * @see cn.nfu.pts.bean.TemplateType#setDisplayIndex(int)
	 */
	public void setDisplayIndex(int displayIndex){
		this.displayIndex = displayIndex;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setName</p>
	 * @param name
	 * @see cn.nfu.pts.bean.TemplateType#setName(java.lang.String)
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:toXMLDocument</p>
	 * @return
	 * @throws Exception
	 * @see cn.nfu.pts.bean.BaseType#toXMLDocument()
	 */
	public Document toXMLDocument() throws Exception
	{
		return XMLUtil.string2Document(toXMLString(), "UTF-8");
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:toXMLString</p>
	 * @return
	 * @throws Exception
	 * @see cn.nfu.pts.bean.BaseType#toXMLString()
	 */
	public String toXMLString() throws Exception
	{
		StringBuffer xmlb = new StringBuffer(64);
		xmlb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");

		xmlb.append("<templateType>");

		xmlb.append("<id>").append(this.getId()).append("</id>");
		xmlb.append("<name>").append(XMLUtil.toSafeXMLString(this.getName())).append("</name>");
		xmlb.append("<description>").append(XMLUtil.toSafeXMLString(this.getDescription())).append("</description>");
		xmlb.append("<displayIndex>").append(this.getDisplayIndex()).append("</displayIndex>");

		xmlb.append("</templateType>");

		return xmlb.toString();
	}
}
