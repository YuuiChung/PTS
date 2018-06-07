package cn.nfu.pts.bean;

import java.io.Serializable;

public class ActionRole implements Serializable{
	
	/**
	 * @Fields:serialVersionUID
	 * @Fields_Type:long
	 * @description:TODO
	 */
	private static final long serialVersionUID = 1L;

	public UUID actionId = null;
	public UUID roleId = null;
	
	/**
	 * <h1> Title:</h1>
	 * <p> Description:init action role</p>
	 * @param actionId
	 * @param roleId
	 */
	public ActionRole(UUID actionId, UUID roleId){
		this.actionId = actionId;
		this.roleId = roleId;
	}

	/**
	 * @description:get action id
	 * @version:v1.0
	 * @return
	 */
	public UUID getActionId()
	{
		return this.actionId;
	}

	/**
	 * @description:get role id
	 * @version:v1.0
	 * @return
	 */
	public UUID getRoleId()
	{
		return this.roleId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:equals</p>
	 * @param o
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o){
		ActionRole ar = (ActionRole)o;
		return (this.actionId.equals(ar.actionId) && this.roleId.equals(ar.roleId));
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:hashCode</p>
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode(){
		return this.actionId.hashCode() ^ this.roleId.hashCode();
	}
}
