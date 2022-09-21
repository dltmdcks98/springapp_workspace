package com.academy.shopping.model.util;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

//정수를 대상으로 세자리 마다 쉼표로 끊어서 통화를 표현 
//ex)100000 -> 100,000
public class CurrencyFormatter {
	public static String getCurrency(long num) {
		DecimalFormat df = new DecimalFormat(",###.###");
		
		return df.format(num);
	}
//	public static void main(String[] args) {
//		System.out.println(getCurrency(120000));
//	}
}
