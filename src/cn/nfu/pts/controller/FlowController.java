package cn.nfu.pts.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.nfu.pts.bean.Action;
import cn.nfu.pts.bean.Flow;
import cn.nfu.pts.bean.Right;
import cn.nfu.pts.bean.Role;
import cn.nfu.pts.bean.Template;
import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.factory.DataAccessFactory;
import cn.nfu.pts.service.ProjectInvolveManager;
import cn.nfu.pts.util.CynthiaUtil;

import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("/flow")
public class FlowController extends BaseController{

	private class FlowField{
		private String fieldId;
		private String fieldName;
		
		public FlowField(String fieldId, String fieldName){
			this.fieldId = fieldId;
			this.fieldName = fieldName;
		}
		public String getFieldId() {
			return fieldId;
		}
		public void setFieldId(String fieldId) {
			this.fieldId = fieldId;
		}
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
	}
	
	/**
	 * @description:get action roles of flow
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getActionRole.do")
	@ResponseBody
	public String getActionRole(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		String actionId = request.getParameter("actionId");
		String flowId = request.getParameter("flowId");
		String userName = (String)request.getSession().getAttribute("userName");
				
		Flow flow = das.queryFlow(DataAccessFactory.getInstance().createUUID(flowId));
		if (flow == null) {
			return "";
		}
		
		Action action = flow.getAction(DataAccessFactory.getInstance().createUUID(actionId));
		
		Map<String, Object> roleMap = new HashMap<String, Object>();
		List<FlowField> allRoleList = new ArrayList<FlowController.FlowField>();
		
		Set<Action> allStartActions = flow.getStartActions();
		
		if(action == null){
			allRoleList.add(new FlowField(Role.everyoneUUID.getValue(), Role.everyoneName));
		}else{
			for(Action startAction : allStartActions){
				//只有新建动作有everyone角色
				if (startAction != null && startAction.getId().getValue().equals(actionId)) {
					allRoleList.add(new FlowField(Role.everyoneUUID.getValue(), Role.everyoneName));
					break;
				}
			}
		}
		
		for (Role role : flow.getRoles()) {
			allRoleList.add(new FlowField(role.getId().getValue(), role.getName()));
		}
		
		roleMap.put("allRole", allRoleList);
		
		if (actionId != null && actionId != "") {
			
			List<FlowField> allActionRoleList = new ArrayList<FlowController.FlowField>();
			Role[] allActionRoles = null;
			
			if (flow.isProFlow()) {
				allActionRoles = ProjectInvolveManager.getInstance().queryActionRoles(userName,flow,DataAccessFactory.getInstance().createUUID(actionId));
			}else {
				allActionRoles = flow.queryActionRoles(DataAccessFactory.getInstance().createUUID(actionId));
			}
			
			for (Role role : allActionRoles) {
				allActionRoleList.add(new FlowField(role.getId().getValue(), role.getName()));
			}
			
			if (flow.isActionEveryoneRole(DataAccessFactory.getInstance().createUUID(actionId))) {
				allActionRoleList.add(new FlowField(Role.everyoneUUID.getValue(), Role.everyoneName));
			}
			roleMap.put("actionRole", allActionRoleList);
		}
		return JSONArray.toJSONString(roleMap);
		
	}
	
	/**
	 * @description:save flow svg info
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveFlowSvg.do")
	@ResponseBody
	public String saveFlowSvg(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		
		String flowId = request.getParameter("flowId");
		Flow flow = das.queryFlow(DataAccessFactory.getInstance().createUUID(flowId));
		if (flow == null) {
			return "false";
		}
		
		String svgCode = request.getParameter("svgCode");
		
		if(das.updateSvg(DataAccessFactory.getInstance().createUUID(flowId), svgCode))
			return "success";
		else 
			return "false";
	}
	
	/**
	 * @description:query flow svg info
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/initFlowSvg.do")
	@ResponseBody
	public String initFlowSvg(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		
		String flowId = request.getParameter("flowId");
		return das.queryFlowSvg(DataAccessFactory.getInstance().createUUID(flowId));
	}
	
	/**
	 * @description:get flow xml
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getFlowXml.do")
	@ResponseBody
	public String getFlowXml(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		
		String flowId = request.getParameter("flowId");
		Flow flow = das.queryFlow(DataAccessFactory.getInstance().createUUID(flowId));
		if (flow == null) {
			return "";
		}
		else {
			return flow.toXMLString();
		}
	}
	
	/**
	 * @description:get flow roles by template
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRoleByTemplate.do")
	@ResponseBody
	public String getRoleByTemplate(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		
		String templateId = request.getParameter("templateId");
		if (templateId == null || templateId.equals("")) {
			return "";
		}
	    Template template = das.queryTemplate(DataAccessFactory.getInstance().createUUID(templateId));
	    
	    if (template == null) {
			return "";
		}
	    
		Flow flow = das.queryFlow(template.getFlowId());
		if (flow == null) {
			return "";
		}
		
		Set<FlowField> allRoleSet = new HashSet<FlowController.FlowField>();
		for (Role role : flow.getRoles()) {
			allRoleSet.add(new FlowField(role.getId().getValue(), role.getName()));
		}
		return JSONArray.toJSONString(allRoleSet);
	}
	
	/**
	 * @description:get flow actions by template
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getActionByTemplate.do")
	@ResponseBody
	public String getActionByTemplate(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		
		String templateId = request.getParameter("templateId");
		if (templateId == null || templateId.equals("")) {
			return "";
		}
	    Template template = das.queryTemplate(DataAccessFactory.getInstance().createUUID(templateId));
	    
	    if (template == null) {
			return "";
		}
	    
		Flow flow = das.queryFlow(template.getFlowId());
		if (flow == null) {
			return "";
		}
		
		Set<FlowField> allRoleSet = new HashSet<FlowController.FlowField>();
		for (Action action : flow.getActions()) {
			allRoleSet.add(new FlowField(action.getId().getValue(), action.getName()));
		}
		return JSONArray.toJSONString(allRoleSet);
	}
	
	/**
	 * @description:get all actions of role 
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getActionByRole.do")
	@ResponseBody
	public String getActionByRole(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		
		String templateId = request.getParameter("templateId");
		String roleIdStr = request.getParameter("roleId");
		if (roleIdStr == null || roleIdStr.length() == 0) {
			return "";
		}
		UUID roleId = DataAccessFactory.getInstance().createUUID(roleIdStr);
		
		if (templateId == null || templateId.equals("")) {
			return "";
		}
	    Template template = das.queryTemplate(DataAccessFactory.getInstance().createUUID(templateId));
	    
	    if (template == null) {
			return "";
		}
	    
		Flow flow = das.queryFlow(template.getFlowId());
		if (flow == null) {
			return "";
		}
		
		Action[] allActions = flow.queryRoleActions(roleId);
		Set<FlowField> allRoleSet = new HashSet<FlowController.FlowField>();
		for (Action action : allActions) {
			if (action != null) {
				allRoleSet.add(new FlowField(action.getId().getValue(), action.getName()));
			}
		}
		return JSONArray.toJSONString(allRoleSet);
	}
	
	
	/**
	 * @description:get flow users
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getFlowUsers.do")
	@ResponseBody
	public String getFlowUsers(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		
		String flowId = request.getParameter("flowId");
		Flow flow = das.queryFlow(DataAccessFactory.getInstance().createUUID(flowId));
		Map<String, String> allUsersMap = new HashMap<String, String>();
		for (Right right : flow.getRightSet()) {
			allUsersMap.put(right.getUsername(), CynthiaUtil.getUserAlias(right.getUsername()));
		}
		return JSONArray.toJSONString(allUsersMap);
		
	}
}
