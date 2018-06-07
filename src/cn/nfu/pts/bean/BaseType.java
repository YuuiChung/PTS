package cn.nfu.pts.bean;

import java.io.Serializable;

import org.w3c.dom.Document;

public interface BaseType extends Serializable{
	
	/**
	 * @description:return data id
	 * @version:v1.0
	 * @return
	 */
	public UUID getId();
	
	/**
	 * @description:clone data
	 * @version:v1.0
	 * @return
	 */
	public BaseType clone();
	
	/**
	 * @description:convert data to document
	 * @version:v1.0
	 * @return
	 * @throws Exception
	 */
	public Document toXMLDocument() throws Exception;
	
	/**
	 * @description:convert data to xml string
	 * @version:v1.0
	 * @return
	 * @throws Exception
	 */
	public String toXMLString() throws Exception;
}
