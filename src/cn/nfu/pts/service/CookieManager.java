package cn.nfu.pts.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {

	/**
	 * @description:set cookie 
	 * @version:v1.0
	 * @param response
	 * @param name:cookie name
	 * @param value:cookie value
	 * @param maxAge:cookie max age
	 */
	public static Cookie addCookie(HttpServletResponse response,String name,String value,int maxAge,String domain){
		Cookie cookie = new Cookie(name,value);
		cookie.setPath("/");
		if(maxAge>0)  cookie.setMaxAge(maxAge);
		if (domain != null && !domain.equals("")) {
			cookie.setDomain(domain);
		}
		response.addCookie(cookie);
		return cookie;
	}

	/**
	 * @description:delete cookie
	 * @version:v1.0
	 * @param response
	 * @param name:cookie name
	 */
	public static void delCookie(HttpServletResponse response,String name){
		Cookie cookie = new Cookie(name,null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	/**
	 * @description:get cookie by cookie name
	 * @version:v1.0
	 * @param request
	 * @param name:cookie name
	 * @return:cookie
	 */
	public static Cookie getCookieByName(HttpServletRequest request,String name){
		Map<String,Cookie> cookieMap = ReadCookieMap(request);
		if(cookieMap.containsKey(name)){
		  Cookie cookie = (Cookie)cookieMap.get(name);
		  return cookie;
		}else{
		  return null;
		} 
	}



	/**
	 * @description:put all cookie from request into map
	 * @version:v1.0
	 * @param request
	 * @return:cookie map
	 */
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){ 
		Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
		Cookie[] cookies = request.getCookies();
		if(null!=cookies){
		  for(Cookie cookie : cookies){
		   cookieMap.put(cookie.getName(), cookie);
		  }
		}
		return cookieMap;
	}

}
