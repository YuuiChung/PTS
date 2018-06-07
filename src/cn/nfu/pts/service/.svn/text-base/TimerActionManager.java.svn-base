package cn.nfu.pts.service;

import java.lang.reflect.Method;

import cn.nfu.pts.bean.Data;
import cn.nfu.pts.bean.TimerAction;

public class TimerActionManager
{	
	private static TimerActionManager instance = null;
	
	public static TimerActionManager getInstance()
	{
		if (instance == null)
			instance = new TimerActionManager();
	
		return instance;
	}

	public void doTimerAction(TimerAction timerAction, Data[] dataArray, String username, String xml)
	{
		if (timerAction == null)
			return;

		try
		{
			Class queryClass = Class.forName(timerAction.getClassName());

			Object queryObject = queryClass.newInstance();
			Method queryMethod = queryClass.getMethod(timerAction.getMethod(), new Class[]{String.class, Data[].class, String.class, String.class});

			queryMethod.invoke(queryObject, new Object[] {timerAction.getId().getValue(), dataArray, username, xml });
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void doTimerAction(TimerAction timerAction, String content, String username, String xml )
	{
		if (timerAction == null)
			return;

		try
		{
			Class queryClass = Class.forName(timerAction.getClassName());

			Object queryObject = queryClass.newInstance();
			Method queryMethod = queryClass.getMethod(timerAction.getMethod(), new Class[]{String.class, String.class, String.class, String.class});

			queryMethod.invoke(queryObject, new Object[] {timerAction.getId().getValue(), content, username, xml });
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
