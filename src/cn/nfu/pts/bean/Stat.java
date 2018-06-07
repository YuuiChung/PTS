package cn.nfu.pts.bean;

import java.io.Serializable;

/**
 * @description:stat interface
 * @version:v1.0
 */
public interface Stat extends Serializable{
	/**
	 * @description:get stat id
	 * @version:v1.0
	 * @return
	 */
	public UUID getId();
	
	/**
	 * @description:get flow id
	 * @version:v1.0
	 * @return
	 */
	public UUID getFlowId();
	
	/**
	 * @description:get stat name
	 * @version:v1.0
	 * @return
	 */
	public String getName();
	
	/**
	 * @description:set stat name
	 * @version:v1.0
	 * @param name
	 */
	public void setName(String name);
	
	public Stat clone();
}
