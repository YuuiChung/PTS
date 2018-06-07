package cn.nfu.pts.service;

import java.util.ArrayList;
import java.util.List;

import bsh.EvalError;
import bsh.Interpreter;

import cn.nfu.pts.bean.Data;
import cn.nfu.pts.bean.ExecuteTime;
import cn.nfu.pts.bean.Script;
import cn.nfu.pts.bean.Single;

public class ScriptExecuteManager
{
	public static List<Interpreter> allDeamonScript = new ArrayList<Interpreter>();

	/**
	 * @description:add script to deamon list
	 * @version:v1.0
	 * @param i
	 */
	public static synchronized void AddDeamonScript(Interpreter i){
		allDeamonScript.add(i);
	}
	
	private final static String RESULT_PREFIX_FAIL = "[fail]";

	private final static String RESULT_PREFIX_SUCCESS = "[success]";

	private static class SingletonHolder{
		private static ScriptExecuteManager scriptExecuteManager = new ScriptExecuteManager();
	}
	
	public static ScriptExecuteManager getInstance()
	{
		return SingletonHolder.scriptExecuteManager;
	}

	private ScriptExecuteManager()
	{
		super();
	}

	/**
	 * @description:execute script
	 * @version:v1.0
	 * @param scriptArray
	 * @param data
	 * @param dataAccessSession
	 * @param scriptAccessSession
	 * @param continueable
	 * @param time
	 * @return
	 */
	public String execute(Script[] scriptArray, Data data, DataAccessSession dataAccessSession, ScriptAccessSession scriptAccessSession, Single<Boolean> continueable,
			ExecuteTime time)
	{
		if (continueable != null)
			continueable.setFirst(true);

		StringBuffer xmlStrb = new StringBuffer();

		for (Script script : scriptArray)
		{
			Interpreter bsh = new Interpreter();
			bsh.setClassLoader(this.getClass().getClassLoader());

			try
			{
				bsh.set("das", dataAccessSession);
				bsh.set("script", script);
				bsh.set("data", data);
				bsh.set("runTime", time);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				MailSender mailSender = new MailSender();
				mailSender.sendMail("项目进度跟踪系统(PTS) 脚本执行错误!", "scriptId"+script.getId(), "1123934927@qq.com");
			}

			if (script.isAsync())
			{
				AddDeamonScript(bsh);
			}
			else
			{
				String result = (String)execute_i(bsh);

				if (result.startsWith(RESULT_PREFIX_FAIL) && continueable != null)
					continueable.setFirst(false);

				xmlStrb.append(makeXMLDoc(script, time, result));
			}
		}

		return xmlStrb.toString();
	}

	protected String makeXMLDoc(Script script, ExecuteTime time, String result)
	{
		StringBuffer strb = new StringBuffer();
		strb.append("<runTime scriptId=\"").append(script.getId()).append("\" type=\"");

		if (time == ExecuteTime.beforeCommit)
			strb.append("beforeCommit");
		else if (time == ExecuteTime.afterSuccess)
			strb.append("afterCommitSuccessed");
		else if (time == ExecuteTime.afterFail)
			strb.append("afterCommitFail");
		else if (time == ExecuteTime.afterQuery)
			strb.append("afterQueryTask");
		strb.append("\" success=\"").append(result.startsWith(RESULT_PREFIX_SUCCESS)).append("\">");

		if (result.startsWith(RESULT_PREFIX_SUCCESS))
			strb.append(result.substring(RESULT_PREFIX_SUCCESS.length()));
		else
			strb.append(result.substring(RESULT_PREFIX_FAIL.length()));

		strb.append("</runTime>");

		return strb.toString();
	}

	protected Object execute_i(Interpreter bsh)
	{
		String content = "";
		try
		{
			Script script = (Script) bsh.get("script");
			if (script == null)
				return null;

			content = script.getScript();
			if (content == null)
				return null;
			return bsh.eval(content);
		}
		catch (EvalError e)
		{
			System.out.println("script content:" + content);
			e.printStackTrace();
		}

		return null;
	}

}
