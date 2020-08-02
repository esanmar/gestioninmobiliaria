package com.emesa.util;

import java.text.DecimalFormat;
import java.text.FieldPosition;

/**
 *
 */
public class Formats {
	static final DecimalFormat DF2 = new DecimalFormat("###,###,##0.00");
	static final DecimalFormat DF = new DecimalFormat("###,###,##0");

	/**
     *
	 * @param num N&uacute;mero a formatear
	 * @return 
	 */
	public static final String integerNumber(double num) {
    		return DF.format(num,new StringBuffer(),new FieldPosition(3)).toString();
	}

	/**
	 *
	 * @param num N&uacute;mero a formatear
	 * @return 
	 */
	public static final String doubleNumber(double num) {
			return DF2.format(num,new StringBuffer(),new FieldPosition(3)).toString();
	}
}