package cn.nfu.pts.bean.impl;

import cn.nfu.pts.bean.Action;
import cn.nfu.pts.bean.UUID;

public class ActionImpl implements Action{
	/**
	 * @Fields:serialVersionUID
	 * @Fields_Type:long
	 * @description:TODO
	 */
	private static final long serialVersionUID = 4653915502714944375L;
	
	//action id
	private UUID id = null;
	//action flow id
	private	UUID flowId	= null;
	//action name
	private String name = null;
	
	private	UUID beginStatId = null;
	
	private	UUID endStatId = null;
	
	//是否可以指派多人
	private boolean assignToMore = false; 
	//指行该动作时是否发送邮件
	private boolean sendMail = false;   
	
	private String sendMailUsers = null;

	/**
	 * <h1> Title:</h1>
	 * <p> Description:init action</p>
	 * @param id
	 * @param flowId
	 */
	public ActionImpl(UUID id, UUID flowId){
		this.id	= id;
		this.flowId	= flowId;
	}
	
	public ActionImpl(UUID id, UUID flowId,String name){
		this.id	= id;
		this.flowId	= flowId;
		this.name = name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getId</p>
	 * <p> Description:TODO</p>
	 * @return
	 * @see cn.nfu.pts.bean.Action#getId()
	 */
	public UUID getId(){
		return this.id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getFlowId</p>
	 * <p> Description:TODO</p>
	 * @return
	 * @see cn.nfu.pts.bean.Action#getFlowId()
	 */
	public UUID getFlowId(){
		return this.flowId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getName</p>
	 * <p> Description:TODO</p>
	 * @return
	 * @see cn.nfu.pts.bean.Action#getName()
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setName</p>
	 * <p> Description:TODO</p>
	 * @param name
	 * @see cn.nfu.pts.bean.Action#setName(java.lang.String)
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getBeginStatId</p>
	 * <p> Description:TODO</p>
	 * @return
	 * @see cn.nfu.pts.bean.Action#getBeginStatId()
	 */
	public UUID getBeginStatId(){
		return this.beginStatId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setBeginStatId</p>
	 * @param beginStatId
	 * @see cn.nfu.pts.bean.Action#setBeginStatId(cn.nfu.pts.bean.UUID)
	 */
	public void setBeginStatId(UUID beginStatId){
		this.beginStatId = beginStatId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getEndStatId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Action#getEndStatId()
	 */
	public UUID getEndStatId(){
		return this.endStatId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setEndStatId</p>
	 * @param endStatId
	 * @see cn.nfu.pts.bean.Action#setEndStatId(cn.nfu.pts.bean.UUID)
	 */
	public void setEndStatId(UUID endStatId){
		this.endStatId = endStatId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:clone</p>
	 * @return
	 * @see java.lang.Object#clone()
	 */
	public Action clone(){
		ActionImpl actionImpl = new ActionImpl(this.id, this.flowId);
		actionImpl.setName(this.name);
		actionImpl.setBeginStatId(this.beginStatId);
		actionImpl.setEndStatId(this.endStatId);

		return actionImpl;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:equals</p>
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj){
		ActionImpl actionImpl = (ActionImpl)obj;
		return (this.id.equals(actionImpl.id) && this.flowId.equals(actionImpl.flowId));
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:hashCode</p>
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode(){
		return this.id.hashCode() ^ this.flowId.hashCode();
	}

	
	/** (non-Javadoc)
	 * <p> Title:getAssignToMore</p>
	 * @return
	 * @see cn.nfu.pts.bean.Action#getAssignToMore()
	 */
	@Override
	public boolean getAssignToMore() {
		return this.assignToMore;
	}

	/** (non-Javadoc)
	 * <p> Title:setAssignToMore</p>
	 * @param assignToMore
	 * @see cn.nfu.pts.bean.Action#setAssignToMore(boolean)
	 */
	@Override
	public void setAssignToMore(boolean assignToMore) {
		this.assignToMore = assignToMore;
	}
}
