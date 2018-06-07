package cn.nfu.pts.bean.impl;

import cn.nfu.pts.bean.Role;
import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.factory.DataAccessFactory;


public class RoleImpl implements Role{
	/**
	 * @Fields:serialVersionUID
	 * @Fields_Type:long
	 * @description:TODO
	 */
	private static final long serialVersionUID = -2849889272670916357L;
	
	private UUID id = null;
	private	UUID flowId = null;
	private String name = null;

	/**
	 * <h1> Title:</h1>
	 * <p> Description:init role</p>
	 * @param id
	 * @param flowId
	 */
	public RoleImpl(UUID id, UUID flowId){
		this.id	= id;
		this.flowId	= flowId;
	}
	
	public RoleImpl(UUID id, UUID flowId,String name){
		this.id	= id;
		this.flowId	= flowId;
		this.name = name;
	}

	public RoleImpl(String id, String flowId,String name){
		this.id	= DataAccessFactory.getInstance().createUUID(id);
		this.flowId	= DataAccessFactory.getInstance().createUUID(flowId);
		this.name = name;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Role#getId()
	 */
	public UUID getId(){
		return this.id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getFlowId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Role#getFlowId()
	 */
	public UUID getFlowId(){
		return this.flowId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getName</p>
	 * @return
	 * @see cn.nfu.pts.bean.Role#getName()
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setName</p>
	 * @param name
	 * @see cn.nfu.pts.bean.Role#setName(java.lang.String)
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:clone</p>
	 * @return
	 * @see java.lang.Object#clone()
	 */
	public Role clone(){
		RoleImpl roleImpl = new RoleImpl(this.id, this.flowId);
		roleImpl.setName(name);

		return roleImpl;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:equals</p>
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj){
		RoleImpl roleImpl = (RoleImpl)obj;
		return (this.id.equals(roleImpl.id) && this.flowId.equals(roleImpl.flowId));
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:hashCode</p>
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode(){
		return this.id.hashCode() ^ this.name.hashCode();
	}
}
