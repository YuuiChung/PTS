package cn.nfu.pts.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.nfu.pts.bean.Key;
import cn.nfu.pts.bean.Timer;
import cn.nfu.pts.bean.TimerAction;
import cn.nfu.pts.factory.DataAccessFactory;
import cn.nfu.pts.service.StatisticerManager;
import cn.nfu.pts.service.DataAccessSession.ErrorCode;
import cn.nfu.pts.util.CommonUtil;
import cn.nfu.pts.util.CynthiaUtil;

import com.alibaba.fastjson.JSONArray;

import edu.emory.mathcs.backport.java.util.Arrays;

@Controller
@RequestMapping("/statistic")
public class StatisticController extends BaseController{

	/**
	 * @description:update a statistic
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public String update(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		

		Key key = (Key)session.getAttribute("key");
		String statId = request.getParameter("statId");
		String statName = request.getParameter("statName");
		String params = request.getParameter("params");
		params = CynthiaUtil.getXMLStr(params);
		String isSendMail = request.getParameter("isSendMail");
		String[] month = request.getParameterValues("month[]");
		String[] date = request.getParameterValues("date[]");
		String[] week = request.getParameterValues("week[]");
		String hour = request.getParameter("hour[]");
		String minute = request.getParameter("minute[]");
		String recievers = request.getParameter("recievers");

		params = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" + params;
		TimerAction timerAction = null;
		Timer timer = null;
		if (statId == null || statId.equals("")) {
			//新创建
			timerAction = das.createTimerAction();
			timerAction.setClassName("cn.nfu.pts.service.StatisticerManager");
			timerAction.setMethod("execute");
			timerAction.setName(statName);
			timerAction.setCreateUser(key.getUsername());
			timerAction.setParam(params);
			if (isSendMail != null && isSendMail.equals("true") && recievers != null && !recievers.equals("")) {
				timer = das.createTimer(key.getUsername());
				timer.setActionId(timerAction.getId());
				timer.setActionParam(timerAction.getParam());
				timer.setName(timerAction.getName());
				timer.setRetry(true);
				timer.setRetryAccount(5);
				timer.setRetryDelay(50000);
				timer.setSendNull(true);
				timer.setStart(true);
				timer.setMonth(CommonUtil.arrayToStr(month));
				timer.setWeek(CommonUtil.arrayToStr(week));
				timer.setDay(CommonUtil.arrayToStr(date));
				timer.setHour(hour);
				timer.setMinute(minute);
				das.addTimer(timer);
			}

			return String.valueOf(das.addTimerAction(timerAction).equals(ErrorCode.success));
		}else {
			timerAction = das.queryTimerAction(DataAccessFactory.getInstance().createUUID(statId));
			//更新统计
			timerAction.setName(statName);
			timerAction.setParam(params);

			Timer[] timerArray = das.queryTimersByActionId(timerAction.getId());

			if (timerArray.length > 0) {
				//己存在定时器更新定时器
				for(int i = 0; i < timerArray.length; i++){
					if(timerArray[i].getActionId().toString().equals(timerAction.getId().toString())){
						timer = timerArray[i];
						timer.setActionParam(timerAction.getParam());
						timer.setName(timerAction.getName());

						if (isSendMail != null && isSendMail.equals("false")) {
							//时间为空则直接删除timer
							das.removeTimer(timer.getId());
						}else {
							//否则更新timer时间
							timer.setMonth(CommonUtil.arrayToStr(month));
							timer.setWeek(CommonUtil.arrayToStr(week));
							timer.setDay(CommonUtil.arrayToStr(date));
							timer.setHour(hour);
							timer.setMinute(minute);
							das.modifyTimer(timer);
						}
						break;
					}
				}
			}else {
				//不存在，创建定时器
				if (isSendMail != null && isSendMail.equals("true") && recievers != null && !recievers.equals("")) {
					timer = das.createTimer(key.getUsername());
					timer.setActionId(timerAction.getId());
					timer.setActionParam(timerAction.getParam());
					timer.setName(timerAction.getName());
					timer.setRetry(true);
					timer.setRetryAccount(5);
					timer.setRetryDelay(50000);
					timer.setSendNull(true);
					timer.setStart(true);
					timer.setMonth(CommonUtil.arrayToStr(month));
					timer.setWeek(CommonUtil.arrayToStr(week));
					timer.setDay(CommonUtil.arrayToStr(date));
					timer.setHour(hour);
					timer.setMinute(minute);
					das.addTimer(timer);
				}

			}

			return String.valueOf(das.modifyTimerAction(timerAction).equals(ErrorCode.success));
		}
	}
	
	/**
	 * @description:query all statistics of user
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryAllStatistics.do")
	@ResponseBody
	public String queryAllStatistics(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		String userName = ((Key)session.getAttribute("key")).getUsername();
		List<TimerAction> allTimerActions = new ArrayList<TimerAction>();
		allTimerActions.addAll(Arrays.asList(das.queryStatisticByUser(userName)));
		return JSONArray.toJSONString(allTimerActions);
	}
	
	/**
	 * @description:delete statistic of user
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteStatistic.do")
	@ResponseBody
	public String deleteStatistic(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		String statId = request.getParameter("statId");
		return String.valueOf(das.removeTimerAction(DataAccessFactory.getInstance().createUUID(statId)).equals(ErrorCode.success));
	}
	
	/**
	 * @description:get statistic info
	 * @version:v1.0
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getStatisticInfo.do")
	@ResponseBody
	public String getStatisticInfo(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws Exception {
		Key key = (Key)session.getAttribute("key");
		String statisticId = request.getParameter("statisticId");
		return JSONArray.toJSONString(StatisticerManager.
				getStatisticResultById(DataAccessFactory.getInstance().createUUID(statisticId), key.getUsername()));
	}

}
