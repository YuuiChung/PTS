package cn.nfu.pts.bean;

import java.io.Serializable;

import cn.nfu.pts.factory.DataAccessFactory;

public interface Role extends Serializable{
	
	/**
	 * @description:get role id
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
	 * @description:get role name
	 * @version:v1.0
	 * @return
	 */
	public String getName();

	/**
	 * @description:set role name
	 * @version:v1.0
	 * @param name
	 */
	public void setName(String name);

	/**
	 * @description:role clone
	 * @version:v1.0
	 * @return
	 */
	public Role clone();

	/**
	 * everyone role id
	 */
	public static UUID everyoneUUID = DataAccessFactory.getInstance().createUUID("82");
	/**
	 * everyone role name
	 */
	public static String everyoneName = "everyone";
}
