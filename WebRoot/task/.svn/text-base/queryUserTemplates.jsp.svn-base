<%@page import="cn.nfu.pts.util.XMLUtil"%>
<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="cn.nfu.pts.bean.Key"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.service.DataManager"%>
<%@ page import="cn.nfu.pts.bean.Data"%>
<%@ page import="cn.nfu.pts.bean.Template"%>
<%@ page import="cn.nfu.pts.bean.Field"%>
<%@ page import="cn.nfu.pts.bean.Option"%>
<%@ page import="cn.nfu.pts.bean.Flow"%>
<%@ page import="cn.nfu.pts.bean.Stat"%>
<%@ page import="cn.nfu.pts.bean.Action"%>
<%@ page import="cn.nfu.pts.bean.Role"%>
<%@ page import="cn.nfu.pts.bean.Attachment"%>
<%@ page import="cn.nfu.pts.bean.Field.Type"%>
<%@ page import="org.w3c.dom.Node"%>
<%@ page import="org.w3c.dom.Document"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.nfu.pts.bean.Option.Forbidden"%>

<%!

static DataAccessFactory daf = DataAccessFactory.getInstance();

String checkXML(String xml, String encode) throws Exception{
	byte[] byteArray = xml.getBytes(encode);
	for(int i = 0; i < byteArray.length; i++){
		if(byteArray[i] == 0x1a || byteArray[i] == 0x19||byteArray[i] == 0x1||byteArray[i]==0x4){
			byteArray[i] = 78;
		}
	}
	return new String(byteArray, encode);
}
%>

<%
	response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
	
	out.clear();

	Long keyId = (Long)session.getAttribute("kid");
	Key key = (Key)session.getAttribute("key");

	if(keyId == null || keyId <= 0 || key == null){
		response.sendRedirect(ConfigUtil.getCynthiaWebRoot());
		return;
	}
	
	DataAccessSession das = daf.createDataAccessSession(key.getUsername(), keyId);
	
	String xml = null;
		
	System.out.println(key.getUsername());
	
	Template[] templateArray  = DataManager.getInstance().queryUserTemplates(key.getUsername());
		
	StringBuffer xmlb = new StringBuffer(64);
	xmlb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		
	xmlb.append("<root>");
		
	xmlb.append("<isError>false</isError>");
		
	if(templateArray.length == 0){
		xmlb.append("<templates/>");
	}else{
		xmlb.append("<templates>");
	
		for(Template template : templateArray){
			xmlb.append("<template>");	
				
			xmlb.append("<id>").append(template.getId()).append("</id>");
			xmlb.append("<name>").append(XMLUtil.toSafeXMLString(template.getName())).append("</name>");
			xmlb.append("<templateType>").append(XMLUtil.toSafeXMLString(template.getTemplateTypeId().getValue())).append("</templateType>");	
			xmlb.append("</template>");
		}
		
		xmlb.append("</templates>");
	}
	
	xmlb.append("</root>");
	xml = xmlb.toString();
	out.println(xml);
%>
