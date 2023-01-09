package com.learn;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;

public class CheckServlet extends HttpServlet {
	public void service(ServletRequest req, ServletResponse res) throws IOException {

		String city = (String) req.getParameter("city");
		
		TimeZone tZone = TimeZone.getTimeZone(city);
		Calendar cal = Calendar.getInstance(tZone);
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		 String amPm = hour > 11 ? "PM" : "AM" ;
         hour = hour%12 ;
         int currectHour = hour == 0 ? 12 : hour ;
         res.getWriter().print("Current time at "+ city + " : " + currectHour + ":" + minute + ":" + second + "  "+amPm);
	}
	
}
