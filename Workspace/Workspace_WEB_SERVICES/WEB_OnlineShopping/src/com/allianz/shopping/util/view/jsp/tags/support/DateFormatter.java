/**
 * 
 */
package com.allianz.shopping.util.view.jsp.tags.support;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.allianz.shopping.util.DateUtility;

/**
 * @author Allianz3076
 *
 */
public class DateFormatter extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date date;
	private String pattern = "dd/MM/yyyy";
	
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		
		try {
			out.print(DateUtility.convertDateToString(getDate(), getPattern()));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SKIP_BODY;
		
	}
	
	
	
}
