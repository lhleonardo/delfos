package br.com.estatistica.bean;

import java.util.Date;

public class DateFormatter implements Formatter {
	
	public static void main (String[]args){
		
	}

	@Override
	public Object format(Object obj) {
		Date date = (Date)obj;
		return date.getDay()+"/"+date.getMonth()+"/"+date.getYear();
	}

	@Override
	public Object parse(Object s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
