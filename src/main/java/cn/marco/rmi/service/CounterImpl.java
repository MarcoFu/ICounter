package cn.marco.rmi.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;


/** 
* Created by IntelliJ IDEA. 
* User: leizhimin 
* Date: 2008-8-7 21:56:47 
* 远程的接口的实现 
*/ 
public class CounterImpl extends UnicastRemoteObject implements ICounter { 
	Object obj_v1000 = "obj_v1000";
	
	private static HashMap<String, MutableIntegers> counter = new HashMap<String, MutableIntegers>(); 
	
	public static HashMap<String, MutableIntegers> getCounter() {
		return counter;
	}
	
	private void addOneCount(String modename) {
		MutableIntegers initValue = new MutableIntegers(1); 
		synchronized (obj_v1000) {
	        // 利用 HashMap 的put方法弹出旧值的特性  
	        MutableIntegers oldValue = counter.put(modename, initValue);  
	        if(oldValue != null){  
	            initValue.set(oldValue.get() + 1);
	        }
		}
	}
	
	private void serCountZero(String modename) {
		if("all".equals(modename)) {
			for(Map.Entry<String, MutableIntegers> entry : counter.entrySet()) {
				String key = entry.getKey();
				MutableIntegers initValue = new MutableIntegers(0); 
		        // 利用 HashMap 的put方法弹出旧值的特性  
		        counter.put(key, initValue);
			}
			
		} else {
			MutableIntegers initValue = new MutableIntegers(0); 
	        // 利用 HashMap 的put方法弹出旧值的特性  
	        counter.put(modename, initValue);
		}
	}
	
	
    /** 
     * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，因此这里默认的构造方法必须写，必须声明抛出RemoteException异常 
     * 
     * @throws RemoteException 
     */ 
    public CounterImpl() throws RemoteException { 
    } 

    /** 
     * 简单的返回“Hello World！"字样 
     * 
     * @return 返回“Hello World！"字样 
     * @throws java.rmi.RemoteException 
     */ 
    public String helloWorld() throws RemoteException { 
        return "Hello World!";
    } 

    /** 
     * 一个简单的业务方法，根据传入的人名返回相应的问候语 
     * 
     * @param someBodyName 人名 
     * @return 返回相应的问候语 
     * @throws java.rmi.RemoteException 
     */ 
    public String addOneToCounter(String modeName) throws RemoteException { 
    	addOneCount(modeName);
        return "ok"; 
    }

	@Override
	public void clearCounter(String modeName) throws RemoteException {
		// TODO Auto-generated method stub
		serCountZero(modeName);
	}

	@Override
	public void printCounter() throws RemoteException {
		// TODO Auto-generated method stub
		PrintCount.print();
	} 
}
