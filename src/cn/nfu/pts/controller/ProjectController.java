package cn.nfu.pts.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.nfu.pts.bean.UserInfo;
import cn.nfu.pts.service.ProjectInvolveManager;

import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController{

	/**
	 * @Title: getAllTemplate
	 * @Description: 通过产品获取项目
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping("/getProjects.do")
	@ResponseBody
	public String getProjects(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		Map<String, String> allProjectsMap = new HashMap<String, String>();
		String userName = (String)request.getSession().getAttribute("userName");
		String productId = request.getParameter("productId");
		allProjectsMap = ProjectInvolveManager.getInstance().getProjectMap(userName, productId);
		return JSONArray.toJSONString(allProjectsMap);
	}
	
	/**
	 * @Title: getAllUsersByRolesAndProductId
	 * @Description: 能过角色Id和项目Id获取所有用户
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 * @return: String
	 */
	@RequestMapping("/getAllUsersByRolesAndProductId.do")
	@ResponseBody
	public String getAllUsersByRolesAndProductId(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		List<UserInfo> allUsers = new ArrayList<UserInfo>();
 		String userName = (String)request.getSession().getAttribute("userName");
		String projectId = request.getParameter("projectId");
		String roleIds = request.getParameter("roles");
		
		allUsers = ProjectInvolveManager.getInstance().getUserInfoByProjectAndRole(userName,projectId, roleIds);
		return JSONArray.toJSONString(allUsers);
	}
}
