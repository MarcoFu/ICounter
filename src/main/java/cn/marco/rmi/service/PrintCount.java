package cn.marco.rmi.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PrintCount {
	private static Logger log = LoggerFactory.getLogger(PrintCount.class);
	
	public static void print() {
		
		HashMap<String, MutableIntegers> counter = CounterImpl.getCounter();
		log.info("Counter print start ---");
		for(Map.Entry<String, MutableIntegers> entry : counter.entrySet()) {
			String key = entry.getKey();
			MutableIntegers mis = entry.getValue();
			log.info("Counter--  "+ key +" : " + mis.toString());
		}
		log.info("Counter print end ---");
		log.info(" ");
		
		return ;
	}

}
