package cn.nfu.pts.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.nfu.pts.factory.DataAccessFactory;
import cn.nfu.pts.service.FilterQueryManager;

import com.alibaba.fastjson.JSONArray;

import edu.emory.mathcs.backport.java.util.Arrays;
@Controller
@RequestMapping("/data")
public class DataController extends BaseController{
	
	/**
	 * @description:update the data log
	 * @version:v1.0
	 * @param request
	 * @param httpSession
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/updateLog.do")
	public String updateLog(HttpServletRequest request, HttpSession httpSession) throws Exception {
		
		String dataId = request.getParameter("dataId");
		int logIndex = Integer.parseInt(request.getParameter("logIndex"));
		String logComment = request.getParameter("logComment");
		return String.valueOf(das.updateDataLog(DataAccessFactory.getInstance().createUUID(dataId), logIndex, logComment));
	}
	
	@ResponseBody
	@RequestMapping("/queryProjectBugNum.do")
	public String queryProjectBugNum(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws Exception {

		String projectIds = request.getParameter("projectIds");
		List<String> allProjects = Arrays.asList(projectIds.split(","));
		
		Map<String, Set<String>> projectDataMap = FilterQueryManager.queryProjectDataIds(allProjects);
		Map<String, Integer> returnMap = new HashMap<String, Integer>();
		
		for(String projectId : allProjects){
			returnMap.put(projectId, 0);
		}
		
		for(String projectId : projectDataMap.keySet()){
			returnMap.put(projectId, projectDataMap.get(projectId).size());
		}
		
		response.addHeader( "Access-Control-Allow-Origin", "*" ); // open your api to any client 
		response.addHeader( "Access-Control-Allow-Methods", "GET" ); // a allow get
		response.addHeader( "Access-Control-Allow-Methods", "POST" ); // a allow post
		response.addHeader( "Access-Control-Max-Age", "1000" ); // 
		
		return JSONArray.toJSONString(returnMap);
	}
}
