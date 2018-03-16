package org.yoshi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Teste {
	
	public static void main(String[] args) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(df.parse("12/08/1985"));
	}
	
}
