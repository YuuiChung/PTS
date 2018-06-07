package cn.nfu.pts.bean;

import java.io.Serializable;

public interface Option extends Serializable{
	/**
	 * @description:get option id
	 * @version:v1.0
	 * @return
	 */
	public UUID getId();
	
	/**
	 * @description:get option field id
	 * @version:v1.0
	 * @return
	 */
	public UUID getFieldId();
	
	/**
	 * @description:get option name
	 * @version:v1.0
	 * @return
	 */
	public String getName();
	
	/**
	 * @description:set option name
	 * @version:v1.0
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * @description:get option description
	 * @version:v1.0
	 * @return
	 */
	public String getDescription();
	
	/**
	 * @description:set option description
	 * @version:v1.0
	 * @param description
	 */
	public void setDescription(String description);
	
	/**
	 * @description:get option control option id
	 * @version:v1.0
	 * @return
	 */
	public UUID getControlOptionId();
	
	/**
	 * @description:set option control option id
	 * @version:v1.0
	 * @param controlOptionId
	 */
	public void setControlOptionId(UUID controlOptionId);
	
	/**
	 * @description:get option father optionid
	 * @version:v1.0
	 * @return
	 */
	public UUID getFatherOptionId();
	
	/**
	 * @description:set option father option
	 * @version:v1.0
	 * @param fatherOptionId
	 */
	public void setFatherOptionId(UUID fatherOptionId);
	
	/**
	 * @description:get option forbidden
	 * @version:v1.0
	 * @return
	 */
	public Forbidden getForbidden();
	
	/**
	 * @description:set option forbidden
	 * @version:v1.0
	 * @param forbidden
	 */
	public void setForbidden(Forbidden forbidden);
	
	/**
	 * @description:get option index from field
	 * @version:v1.0
	 * @return
	 */
	public int getIndexOrder();
	
	/**
	 * @description:set option index from field
	 * @version:v1.0
	 * @param indexOrder
	 */
	public void setIndexOrder(int indexOrder);
	
	/**
	 * @description:option clone
	 * @version:v1.0
	 * @return
	 */
	public Option clone();
	
	/**
	 * @description:option to xml string
	 * @version:v1.0
	 * @return
	 */
	public String toXMLString();
	
	public enum Forbidden{
		f_forbidden, f_permit;
	}
}
