package br.com.estatistica.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConversorData {

	public ConversorData() {

	}

	public java.util.Date sqlParaUtil(java.sql.Date dataSQL) throws ParseException {
		java.util.Date dataUtil = new java.util.Date();
		DateFormat formatadorData = new SimpleDateFormat();
		String dataConvertida = formatadorData.format(dataSQL);
		dataUtil = formatadorData.parse(dataConvertida);

		return dataUtil;
	}

}
