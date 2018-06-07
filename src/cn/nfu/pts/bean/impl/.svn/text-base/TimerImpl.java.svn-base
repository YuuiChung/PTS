package cn.nfu.pts.bean.impl;

import java.sql.Timestamp;

import cn.nfu.pts.bean.TimeRegulate;
import cn.nfu.pts.bean.Timer;
import cn.nfu.pts.bean.UUID;

public class TimerImpl implements Timer
{
	/**
	 * @Fields:serialVersionUID
	 * @Fields_Type:long
	 * @description:TODO
	 */
	private static final long serialVersionUID = -2623899443413328311L;

	private UUID id = null;
	private String name = null;
	private String createUser = null;
	private Timestamp createTime = null;
	private UUID actionId = null;
	private String actionParam = null;
	private UUID filterId = null;
	private UUID statisticerId = null;
	private String year = null;
	private String month = null;
	private String week = null;
	private String day = null;
	private String hour = null;
	private String minute = null;
	private String second = null;
	private boolean isStart = false;
	private long retryAccount = 0;
	private long retryDelay = 0;
	private boolean isRetry = false;
	private Timestamp lastTimestamp = null;
	private Integer timerQueueId = null;
	private boolean isSendNull = false;

	/**
	 * <h1> Title:</h1>
	 * <p> Description:init timer</p>
	 * @date：2014-5-6 
	 * @param id
	 * @param createUser
	 * @param createTime
	 */
	public TimerImpl(UUID id, String createUser, Timestamp createTime)
	{
		super();
		
		this.id = id;
		this.createUser = createUser;
		this.createTime = createTime;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getActionId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getActionId()
	 */
	public UUID getActionId()
	{
		return actionId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setActionId</p>
	 * @param actionId
	 * @see cn.nfu.pts.bean.Timer#setActionId(cn.nfu.pts.bean.UUID)
	 */
	public void setActionId(UUID actionId)
	{
		this.actionId = actionId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getActionParam</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getActionParam()
	 */
	public String getActionParam()
	{
		return actionParam;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setActionParam</p>
	 * @param actionParam
	 * @see cn.nfu.pts.bean.Timer#setActionParam(java.lang.String)
	 */
	public void setActionParam(String actionParam)
	{
		this.actionParam = actionParam;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getCreateUser</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getCreateUser()
	 */
	public String getCreateUser()
	{
		return createUser;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getDay</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getDay()
	 */
	public String getDay()
	{
		return day;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setDay</p>
	 * @param day
	 * @see cn.nfu.pts.bean.Timer#setDay(java.lang.String)
	 */
	public void setDay(String day)
	{
		this.day = day;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getHour</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getHour()
	 */
	public String getHour()
	{
		return hour;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setHour</p>
	 * @param hour
	 * @see cn.nfu.pts.bean.Timer#setHour(java.lang.String)
	 */
	public void setHour(String hour)
	{
		this.hour = hour;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getId()
	 */
	public UUID getId()
	{
		return id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getMinute</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getMinute()
	 */
	public String getMinute()
	{
		return minute;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setMinute</p>
	 * @param minute
	 * @see cn.nfu.pts.bean.Timer#setMinute(java.lang.String)
	 */
	public void setMinute(String minute)
	{
		this.minute = minute;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getMonth</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getMonth()
	 */
	public String getMonth()
	{
		return month;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setMonth</p>
	 * @param month
	 * @see cn.nfu.pts.bean.Timer#setMonth(java.lang.String)
	 */
	public void setMonth(String month)
	{
		this.month = month;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getName</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getName()
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setName</p>
	 * @param name
	 * @see cn.nfu.pts.bean.Timer#setName(java.lang.String)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getSecond</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getSecond()
	 */
	public String getSecond()
	{
		return second;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setSecond</p>
	 * @param second
	 * @see cn.nfu.pts.bean.Timer#setSecond(java.lang.String)
	 */
	public void setSecond(String second)
	{
		this.second = second;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getWeek</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getWeek()
	 */
	public String getWeek()
	{
		return week;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setWeek</p>
	 * @param week
	 * @see cn.nfu.pts.bean.Timer#setWeek(java.lang.String)
	 */
	public void setWeek(String week)
	{
		this.week = week;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getYear</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getYear()
	 */
	public String getYear()
	{
		return year;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setYear</p>
	 * @param year
	 * @see cn.nfu.pts.bean.Timer#setYear(java.lang.String)
	 */
	public void setYear(String year)
	{
		this.year = year;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:takeNextAlarmTime</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#takeNextAlarmTime()
	 */
	public Timestamp takeNextAlarmTime()
	{
		TimeRegulate timeRegulate = takeTimeRegulate();
		if (timeRegulate == null)
			return null;

		Timestamp current = new Timestamp(timeRegulate.getNextScheduleTime().getTime() / 60000 * 60000);

		if (lastTimestamp != null)
		{
			if (lastTimestamp.getTime() == current.getTime())
				current = new Timestamp(current.getTime() + 60000);
		}

		lastTimestamp = current;

		return current;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:takeTimeRegulate</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#takeTimeRegulate()
	 */
	public TimeRegulate takeTimeRegulate()
	{
		if (this.month == null || (this.day == null && this.week == null) || this.hour == null || this.minute == null)
			return null;

		TimeRegulate timeRegulate = new TimeRegulate();

		timeRegulate.getMonthSet().clear();
		String[] month = this.getMonth().split(",");
		for (int i = 0; i < month.length && month[i] != null && month[i].trim().length() != 0; i++)
			timeRegulate.getMonthSet().add(Integer.parseInt(month[i]));

		if (timeRegulate.getMonthSet().isEmpty())
			return null;

		timeRegulate.getDateSet().clear();
		String[] date = this.getDay().split(",");
		for (int i = 0; i < date.length && date[i] != null && date[i].trim().length() != 0; i++)
			timeRegulate.getDateSet().add(Integer.parseInt(date[i]));

		if (timeRegulate.getDateSet().isEmpty())
			return null;

		timeRegulate.getDaySet().clear();
		String[] week = this.getWeek().split(",");
		for (int i = 0; i < week.length && week[i] != null && week[i].trim().length() != 0; i++)
			timeRegulate.getDaySet().add(Integer.parseInt(week[i]));

		if (timeRegulate.getDaySet().isEmpty())
			return null;

		timeRegulate.getHourSet().clear();
		String[] hour = this.getHour().split(",");
		for (int i = 0; i < hour.length && hour[i] != null && hour[i].trim().length() != 0; i++)
			timeRegulate.getHourSet().add(Integer.parseInt(hour[i]));

		if (timeRegulate.getHourSet().isEmpty())
			return null;

		timeRegulate.getMinuteSet().clear();
		String[] minute = this.getMinute().split(",");
		for (int i = 0; i < minute.length && minute[i] != null && minute[i].trim().length() != 0; i++)
			timeRegulate.getMinuteSet().add(Integer.parseInt(minute[i]));

		if (timeRegulate.getMinuteSet().isEmpty())
			return null;

		timeRegulate.getSecondSet().clear();
		timeRegulate.getSecondSet().add(0);

		return timeRegulate;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:isStart</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#isStart()
	 */
	public boolean isStart()
	{
		return isStart;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setStart</p>
	 * @param isStart
	 * @see cn.nfu.pts.bean.Timer#setStart(boolean)
	 */
	public void setStart(boolean isStart)
	{
		this.isStart = isStart;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:reachTimerQueueId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#reachTimerQueueId()
	 */
	public Integer reachTimerQueueId()
	{
		return timerQueueId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setTimerQueueId</p>
	 * @param timerQueueId
	 * @see cn.nfu.pts.bean.Timer#setTimerQueueId(java.lang.Integer)
	 */
	public void setTimerQueueId(Integer timerQueueId)
	{
		this.timerQueueId = timerQueueId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getFilterId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getFilterId()
	 */
	public UUID getFilterId()
	{
		return filterId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setFilterId</p>
	 * @param filterId
	 * @see cn.nfu.pts.bean.Timer#setFilterId(cn.nfu.pts.bean.UUID)
	 */
	public void setFilterId(UUID filterId)
	{
		this.filterId = filterId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getStatisticerId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getStatisticerId()
	 */
	public UUID getStatisticerId()
	{
		return statisticerId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setStatisticerId</p>
	 * @param statisticerId
	 * @see cn.nfu.pts.bean.Timer#setStatisticerId(cn.nfu.pts.bean.UUID)
	 */
	public void setStatisticerId(UUID statisticerId)
	{
		this.statisticerId = statisticerId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getRetryAccount</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getRetryAccount()
	 */
	public long getRetryAccount()
	{
		return retryAccount;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setRetryAccount</p>
	 * @param retryAccount
	 * @see cn.nfu.pts.bean.Timer#setRetryAccount(long)
	 */
	public void setRetryAccount(long retryAccount)
	{
		this.retryAccount = retryAccount;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getRetryDelay</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getRetryDelay()
	 */
	public long getRetryDelay()
	{
		return retryDelay;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setRetryDelay</p>
	 * @param retryDelay
	 * @see cn.nfu.pts.bean.Timer#setRetryDelay(long)
	 */
	public void setRetryDelay(long retryDelay)
	{
		this.retryDelay = retryDelay;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getCreateTime</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getCreateTime()
	 */
	public Timestamp getCreateTime()
	{
		return createTime;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:isRetry</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#isRetry()
	 */
	public boolean isRetry()
	{
		return isRetry;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setRetry</p>
	 * @param isRetry
	 * @see cn.nfu.pts.bean.Timer#setRetry(boolean)
	 */
	public void setRetry(boolean isRetry)
	{
		this.isRetry = isRetry;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:isSendNull</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#isSendNull()
	 */
	public boolean isSendNull()
	{
		return isSendNull;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setSendNull</p>
	 * @param isSendNull
	 * @see cn.nfu.pts.bean.Timer#setSendNull(boolean)
	 */
	public void setSendNull(boolean isSendNull)
	{
		this.isSendNull = isSendNull;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:clone</p>
	 * @return
	 * @see java.lang.Object#clone()
	 */
	public Object clone()
	{
		TimerImpl t = new TimerImpl(id, createUser, createTime);

		t.actionId = this.actionId;
		t.actionParam = this.actionParam;
		t.day = this.day;
		t.filterId = this.filterId;
		t.hour = this.hour;
		t.isStart = true;

		if (this.lastTimestamp != null)
			t.lastTimestamp = new Timestamp(this.lastTimestamp.getTime());

		t.minute = this.minute;
		t.month = this.month;
		t.name = this.name;
		t.second = this.second;
		t.statisticerId = this.statisticerId;
		t.timerQueueId = this.timerQueueId;
		t.week = this.week;
		t.year = this.year;

		t.retryAccount = this.retryAccount;
		t.retryDelay = this.retryDelay;
		t.isRetry = true;

		return t;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getRetry</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getRetry()
	 */
	@Override
	public boolean getRetry() {
		return isRetry;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getStart</p>
	 * @return
	 * @see cn.nfu.pts.bean.Timer#getStart()
	 */
	@Override
	public boolean getStart() {
		return isStart;
	}
}
