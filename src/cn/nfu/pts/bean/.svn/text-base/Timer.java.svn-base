package cn.nfu.pts.bean;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * @description:timer interface
 * @version:v1.0
 */
public interface Timer extends Serializable
{
	/**
	 * @description:get timer action id
	 * @version:v1.0
	 * @return
	 */
	public UUID getActionId();

	/**
	 * @description:set timer action id
	 * @version:v1.0
	 * @param actionId
	 */
	public void setActionId(UUID actionId);

	/**
	 * @description:get timer action param
	 * @version:v1.0
	 * @return
	 */
	public String getActionParam();

	/**
	 * @description:set timer action param
	 * @version:v1.0
	 * @param actionParam
	 */
	public void setActionParam(String actionParam);

	/**
	 * @description:get timer create user
	 * @version:v1.0
	 * @return
	 */
	public String getCreateUser();

	/**
	 * @description:get timer execute day
	 * @version:v1.0
	 * @return
	 */
	public String getDay();

	/**
	 * @description:set timer execute day
	 * @version:v1.0
	 * @param day
	 */
	public void setDay(String day);

	/**
	 * @description:get timer execute hour
	 * @version:v1.0
	 * @return
	 */
	public String getHour();

	/**
	 * @description:set timer execute hour
	 * @version:v1.0
	 * @param hour
	 */
	public void setHour(String hour);

	/**
	 * @description:get timer id
	 * @version:v1.0
	 * @return
	 */
	public UUID getId();

	/**
	 * @description:get timer execute minute
	 * @version:v1.0
	 * @return
	 */
	public String getMinute();

	/**
	 * @description:set timer execute minute
	 * @version:v1.0
	 * @param minute
	 */
	public void setMinute(String minute);

	/**
	 * @description:get timer execute month
	 * @version:v1.0
	 * @return
	 */
	public String getMonth();

	/**
	 * @description:set timer execute month
	 * @version:v1.0
	 * @param month
	 */
	public void setMonth(String month);

	/**
	 * @description:get timer action
	 * @version:v1.0
	 * @return
	 */
	public String getName();

	/**
	 * @description:set timer name
	 * @version:v1.0
	 * @param name
	 */
	public void setName(String name);

	/**
	 * @description:get timer execute second
	 * @version:v1.0
	 * @return
	 */
	public String getSecond();

	/**
	 * @description:set timer execute second
	 * @version:v1.0
	 * @param second
	 */
	public void setSecond(String second);

	/**
	 * @description:get timer execute  week
	 * @version:v1.0
	 * @return
	 */
	public String getWeek();

	/**
	 * @description:set timer execute week
	 * @version:v1.0
	 * @param week
	 */
	public void setWeek(String week);

	/**
	 * @description:get timer execute  year
	 * @version:v1.0
	 * @return
	 */
	public String getYear();

	/**
	 * @description:set timer execute year
	 * @version:v1.0
	 * @param year
	 */
	public void setYear(String year);

	/**
	 * @description:TODO
	 * @version:v1.0
	 * @return
	 */
	public Timestamp takeNextAlarmTime();

	/**
	 * @description:TODO
	 * @version:v1.0
	 * @return
	 */
	public TimeRegulate takeTimeRegulate();
	
	/**
	 * @description:get if timer is start
	 * @version:v1.0
	 * @return
	 */
	public boolean isStart();

	/**
	 * @description:set timer is start
	 * @version:v1.0
	 * @param isStart
	 */
	public void setStart(boolean isStart);

	/**
	 * @description:TODO
	 * @version:v1.0
	 * @return
	 */
	public Integer reachTimerQueueId();

	/**
	 * @description:TODO
	 * @version:v1.0
	 * @param timerQueueId
	 */
	public void setTimerQueueId(Integer timerQueueId);

	/**
	 * @description:get timer filter id
	 * @version:v1.0
	 * @return
	 */
	public UUID getFilterId();

	/**
	 * @description:set timer filter id
	 * @version:v1.0
	 * @param filterId
	 */
	public void setFilterId(UUID filterId);

	/**
	 * @description:get timer statisticre id
	 * @version:v1.0
	 * @return
	 */
	public UUID getStatisticerId();

	/**
	 * @description:set timer statisticer id
	 * @version:v1.0
	 * @param statisticerId
	 */
	public void setStatisticerId(UUID statisticerId);

	/**
	 * @description:get timer retry count after fail
	 * @version:v1.0
	 * @return
	 */
	public long getRetryAccount();

	/**
	 * @description:set timer retry count after fail
	 * @version:v1.0
	 * @param retryAccount
	 */
	public void setRetryAccount(long retryAccount);

	/**
	 * @description:get timer retry time
	 * @version:v1.0
	 * @return
	 */
	public long getRetryDelay();

	/**
	 * @description:set retry time after timer fail
	 * @version:v1.0
	 * @param retryDelay
	 */
	public void setRetryDelay(long retryDelay);
	
	/**
	 * @description:get timer create time
	 * @version:v1.0
	 * @return
	 */
	public Timestamp getCreateTime();
	
	/**
	 * @description:get if timer retry after fail
	 * @version:v1.0
	 * @return
	 */
	public boolean isRetry();
	
	/**
	 * @description:return if send null of timer
	 * @version:v1.0
	 * @return
	 */
	public boolean isSendNull();

	/**
	 * @description:set timer send null
	 * @version:v1.0
	 * @param sendNull
	 */
	public void setSendNull(boolean sendNull);

	/**
	 * @description:set timer retry
	 * @version:v1.0
	 * @param isRetry
	 */
	public void setRetry(boolean isRetry);
	
	/**
	 * @description:get timer if retry
	 * @version:v1.0
	 * @return
	 */
	public boolean getRetry();
	
	/**
	 * @description:get timer start
	 * @version:v1.0
	 * @return
	 */
	public boolean getStart();

	/**
	 * @description:timer clone
	 * @version:v1.0
	 * @return
	 */
	public Object clone();
}
