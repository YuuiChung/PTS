package cn.nfu.pts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.nfu.pts.bean.TagBean;
import cn.nfu.pts.dao.TagAccessSessionMySQL;
import cn.nfu.pts.util.CommonUtil;

import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("/tag")
public class TagController extends BaseController{

	/**
	 * @description:get all tas of user
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAllTag.do")
	@ResponseBody
	public String getAllTag(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		if (session.getAttribute("userName") == null) {
			return "";
		}
		
		String userName = session.getAttribute("userName").toString();
		
		List<TagBean> allTagList = das.getAllTag(userName);
		return JSONArray.toJSONString(allTagList);
	}
	
	/**
	 * @description:add a tag for user
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addTag.do")
	@ResponseBody
	public String addTag(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		if (session.getAttribute("userName") == null) {
			return "";
		}
		String tagName = request.getParameter("tagName");
		if(tagName == null || tagName.length() == 0)
			return "";
		
		String tagColor = request.getParameter("tagColor");
		if(tagColor == null || tagColor.length() == 0)
			tagColor = "#990000"; //红色
		
		String userName = session.getAttribute("userName").toString();
		
		int i = das.addTag(userName, tagName, tagColor);
		return String.valueOf(i);
	}
	
	/**
	 * @description:remove a tag of user
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/removeTag.do")
	@ResponseBody
	public String removeTag(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		if (session.getAttribute("userName") == null) {
			return "";
		}
		String tagId = request.getParameter("tagId");
		if(tagId == null || tagId.length() == 0)
			return "";
		
		boolean result = das.deleteTag(tagId);
		return String.valueOf(result);
	}
	
	/**
	 * @description:modify a tag of user
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyTag.do")
	@ResponseBody
	public String modifyTag(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		if (session.getAttribute("userName") == null) {
			return "";
		}
		
		String tagId = request.getParameter("tagId");
		if(tagId == null || tagId.length() == 0)
			return "";
		
		String tagName = request.getParameter("tagName");
		if(tagName == null || tagName.length() == 0)
			return "";
		
		String tagColor = request.getParameter("tagColor");
		if(tagColor == null || tagColor.length() == 0)
			tagColor = "#990000"; //红色
		
		boolean result = das.updateTag(tagId, tagName,tagColor);
		return String.valueOf(result);
	}
	
	
	/**
	 * @description:add a data into tag
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addTagData.do")
	@ResponseBody
	public String addTagData(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		if (session.getAttribute("userName") == null) {
			return "";
		}
		
		String[] dataIds = request.getParameterValues("dataIds[]");
		if(dataIds.length == 0 )
			return "true";
		
		String fromTagId = request.getParameter("fromTagId");
		
		if(fromTagId != null && fromTagId.length() > 0)
			new TagAccessSessionMySQL().deleteTagData(fromTagId, dataIds);
		
		
		String toTagId = request.getParameter("toTagId");
		if(toTagId == null || toTagId.length() == 0)
			return "";
		
		boolean result = das.addTagData(toTagId, dataIds);
		return String.valueOf(result);
	}
	
	/**
	 * @description:remove a data from tag
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteTagData.do")
	@ResponseBody
	public String deleteTagData(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		if (session.getAttribute("userName") == null) {
			return "";
		}
		
		String tagId = request.getParameter("tagId");
		
		String[] dataIds = request.getParameterValues("dataIds[]");
		
		if(dataIds.length == 0 )
			return "true";
		
		boolean result = das.deleteTagData(tagId, dataIds);
		return String.valueOf(result);
	}
	
	/**
	 * @description:get all data ids of tag
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getTagDatas.do")
	@ResponseBody
	public String getTagDatas(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		
		String tagId = request.getParameter("tagId");
		if(tagId == null || tagId.length() == 0)
			return "";
		
		String[] tagDatasArray = das.getTagDataById(tagId);
		if(tagDatasArray == null || tagDatasArray.length == 0)
			return "";
		return CommonUtil.arrayToStr(tagDatasArray);
	}
	
	/**
	 * @description:get all tags of data
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDataTags.do")
	@ResponseBody
	public String geDataTags(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		
		String dataId = request.getParameter("dataId");
		if(dataId == null || dataId.length() == 0)
			return "";
		
		if (session.getAttribute("userName") == null) {
			return "";
		}
		
		String userName = session.getAttribute("userName").toString();
		
		List<TagBean> allTagList = das.getDataTags(userName,dataId);
		return JSONArray.toJSONString(allTagList);
	}
	
}
