package cn.nfu.pts.bean;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import bsh.Interpreter;

import cn.nfu.pts.factory.DataAccessFactory;
import cn.nfu.pts.service.DataAccessSession;
import cn.nfu.pts.service.ScriptAccessSession;
import cn.nfu.pts.util.ConfigUtil;
import cn.nfu.pts.util.XMLUtil;
public class ScriptAction
{
	/**
	 * @description:execute action
	 * @version:v1.0
	 * @param id:action id
	 * @param content:action name
	 * @param username:current user
	 * @param xml:action xml
	 * @return
	 */
	public boolean execute(String id,String content, String username, String xml){
		return executeInternal(id,username, xml);
	}
	
	public boolean execute(String id,Data[] dataArray, String username, String xml){
		return executeInternal(id,username, xml);
	}
	
	/**
	 * @description:execute action
	 * @version:v1.0
	 * @param id:action id
	 * @param username:current user
	 * @param xml:action xml
	 * @return
	 */
	protected boolean executeInternal(String id,String username, String xml){
		try{
			DataAccessSession das = DataAccessFactory.getInstance().createDataAccessSession(username, ConfigUtil.magic);
			ScriptAccessSession sas = das.createScriptAccessSession();
			Document doc = XMLUtil.string2Document(xml, "UTF-8");
			Node rootNode = XMLUtil.getSingleNode(doc, "root");
			
			List<Node> scriptIdNodeList = XMLUtil.getNodes(rootNode, "scriptId");
			for(Node scriptIdNode : scriptIdNodeList){
				UUID scriptId = DataAccessFactory.getInstance().createUUID(scriptIdNode.getTextContent());
				Script script = sas.queryScript(scriptId);
				if(script == null){
					continue;
				}
				Interpreter bsh = new Interpreter();
				bsh.setClassLoader(this.getClass().getClassLoader());
				bsh.set("das", das);
				bsh.eval(script.getScript());
			}
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
}
