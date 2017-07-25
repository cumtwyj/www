package org.fkit.bookstore.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionListener
 *
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	private static Integer number=0;
    /**
     * Default constructor. 
     */
    public MyHttpSessionListener() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		number++;
		se.getSession().getServletContext().setAttribute("number", number);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		number--;
		se.getSession().getServletContext().setAttribute("number", number);
	}

	public static Integer getNumber() {
		return number;
	}

	public static void setNumber(Integer number) {
		MyHttpSessionListener.number = number;
	}
	
}
