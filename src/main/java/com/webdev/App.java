package com.webdev;

import com.webdev.utils.HibernateUtil;

public class App {
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
	}
}