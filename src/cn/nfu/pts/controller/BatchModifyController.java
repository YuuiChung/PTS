package cn.nfu.pts.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.factory.DataAccessFactory;
import cn.nfu.pts.service.DataAccessSession;
import cn.nfu.pts.service.DataManager;
import cn.nfu.pts.util.ConfigUtil;
import cn.nfu.pts.util.CynthiaUtil;
import cn.nfu.pts.util.XMLUtil;

import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("/batchModify")
public class BatchModifyController extends BaseController{

	/**
	 * 
	 * @Title:getHomeFilter
	 * @Type:BatchModifyController
	 * @description:return the usable actions and users for batch modify data
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getModifyActionAndUser.do")
	@ResponseBody
	public String getModifyActionAndUser(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		
		String[] dataIdStrArray = request.getParameterValues("dataIds[]");
		if(dataIdStrArray == null || dataIdStrArray.length == 0){
			return "";
		}
		
		UUID[] dataIdArray = new UUID[dataIdStrArray.length];
		for(int i = 0; i < dataIdArray.length; i++){
			dataIdArray[i] = DataAccessFactory.getInstance().createUUID(dataIdStrArray[i]);
		}
		
		String actionsXML = DataManager.getInstance().getActionsXML(dataIdArray, session.getAttribute("userName").toString());
		
		if(actionsXML == null){
			return "";
		}
		
		Map<String, Map<String,String>> actionUserMap = new LinkedHashMap<String, Map<String,String>>();
		
		Document document = XMLUtil.string2Document(actionsXML, "UTF-8");
		List<Node> actionNodeList = XMLUtil.getNodes(document, "actions/action");
		for(Node actionNode : actionNodeList){
			String actionName = XMLUtil.getSingleNodeTextContent(actionNode, "name");
			actionUserMap.put(actionName, new HashMap<String,String>());
			
			List<Node> userNodeList = XMLUtil.getNodes(actionNode, "users/user");
			for(Node userNode : userNodeList){
				actionUserMap.get(actionName).put(userNode.getTextContent(),CynthiaUtil.getUserAlias(userNode.getTextContent()));
			}
		}
		
		return JSONArray.toJSONString(actionUserMap);
	}
	
	/**
	 * 
	 * @Title:getCloseActionAndUser
	 * @Type:BatchModifyController
	 * @description:return the usable actions and users for batch close data
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCloseActionAndUser.do")
	@ResponseBody
	public String getCloseActionAndUser(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		
		String[] dataIdStrArray = request.getParameterValues("dataIds[]");
		if(dataIdStrArray == null || dataIdStrArray.length == 0){
			return "";
		}
		
		UUID[] dataIdArray = new UUID[dataIdStrArray.length];
		for(int i = 0; i < dataIdArray.length; i++){
			dataIdArray[i] = DataAccessFactory.getInstance().createUUID(dataIdStrArray[i]);
		}
		
		DataAccessSession das = DataAccessFactory.getInstance().createDataAccessSession(session.getAttribute("userName").toString(), ConfigUtil.magic);
		
		String actionsXML = DataManager.getInstance().getBatchCloseActionsXML(dataIdArray, das);
		
		if(actionsXML == null){
			return "";
		}
		
		Map<String, Set<String>> actionUserMap = new LinkedHashMap<String, Set<String>>();
		
		Document document = XMLUtil.string2Document(actionsXML, "UTF-8");
		List<Node> actionNodeList = XMLUtil.getNodes(document, "actions/action");
		for(Node actionNode : actionNodeList){
			String actionName = XMLUtil.getSingleNodeTextContent(actionNode, "name");
			actionUserMap.put(actionName, new LinkedHashSet<String>());
		}
		
		return JSONArray.toJSONString(actionUserMap);
	}
	
}
