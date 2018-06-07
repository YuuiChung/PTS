package cn.nfu.pts.bean;

import java.io.Serializable;

import cn.nfu.pts.factory.DataAccessFactory;

public interface Action extends Serializable{
	
	/**
	 * @description:get action id
	 * @version:v1.0
	 * @return
	 */
	public UUID getId();

	/**
	 * @description:return can assign to more users
	 * @version:v1.0
	 * @return
	 */
	public boolean getAssignToMore();
	
	/**
	 * @description:set can assign to more users
	 * @version:v1.0
	 * @param assignToMore
	 */
	public void setAssignToMore(boolean assignToMore);
	/**
	 * @description:get action flow id
	 * @version:v1.0
	 * @return
	 */
	public UUID getFlowId();

	/**
	 * @description:get action name
	 * @version:v1.0
	 * @return
	 */
	public String getName();

	/**
	 * @description:set action name
	 * @version:v1.0
	 * @param name
	 */
	public void setName(String name);

	/**
	 * @description:get action begin stat id
	 * @version:v1.0
	 * @return
	 */
	public UUID getBeginStatId();

	/**
	 * @description:set action begin stat id
	 * @version:v1.0
	 * @param statId
	 */
	public void setBeginStatId(UUID statId);

	/**
	 * @description:get action end stat id
	 * @version:v1.0
	 * @return
	 */
	public UUID getEndStatId();

	/**
	 * @description:set action end stat id
	 * @version:v1.0
	 * @param statId
	 */
	public void setEndStatId(UUID statId);
	
	public Action clone();

	/**
	 * edit action id
	 */
	public static UUID editUUID = DataAccessFactory.getInstance().createUUID("48");
	public static String editName = "编辑";

	/**
	 * read action id
	 */
	public static UUID readUUID = DataAccessFactory.getInstance().createUUID("47");
	public static String readName = "查看";

	/**
	 * delete action id
	 */
	public static UUID deleteUUID = DataAccessFactory.getInstance().createUUID("51");
	public static String deleteName = "删除";


}
