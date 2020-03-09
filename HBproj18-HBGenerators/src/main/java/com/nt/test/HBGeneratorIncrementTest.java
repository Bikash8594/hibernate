package com.nt.test;

public class HBGeneratorIncrementTest {

	public static void main(String[] args) {
		SaveObjectThread so=null;
		Thread th1=null,th2=null,th3=null;
		//create Threads
		 so=new SaveObjectThread();
		 th1=new Thread(so);
		 th2=new Thread(so);
		 th3=new Thread(so);
		 //start the threads
		 th1.start();
		 th2.start();
		 th3.start();
		 

	}

}
