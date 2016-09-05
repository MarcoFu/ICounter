package cn.marco.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import cn.marco.rmi.service.ICounter;


/** 
* Created by IntelliJ IDEA. 
* User: leizhimin 
* Date: 2008-8-7 22:21:07 
* 客户端测试，在客户端调用远程对象上的远程方法，并返回结果。 
*/ 
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class CounterClient {
	private static String rmiUrl = "rmi://127.0.0.1:8889/RCounter";
	public static void addCount(String rmi_url, String modeName) {
        try { 
            //在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法 
            ICounter rcounter =(ICounter) Naming.lookup(rmi_url); 
           // System.out.println(rcounter.helloWorld()); 
            String result = rcounter.addOneToCounter(modeName);
            if(!"ok".equals(result)) {
            	System.out.println("ICounter is not ok...!");
            }
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	
	public static void addCount(String modeName) {
		addCount(rmiUrl, modeName);
	}
	
	public static void clearCount(String rmi_url, String modeName) {
		try { 
            //在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法 
            ICounter rcounter =(ICounter) Naming.lookup(rmi_url); 
           // System.out.println(rcounter.helloWorld()); 
            rcounter.clearCounter(modeName);
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	
	public static void clearCount(String modeName) {
		clearCount(rmiUrl, modeName);
	}
	
	public static void printCounter(String rmi_url) {
        try { 
            //在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法 
            ICounter rcounter =(ICounter) Naming.lookup(rmi_url); 
           // System.out.println(rcounter.helloWorld()); 
            rcounter.printCounter();
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public static void printCounter() {
		printCounter(rmiUrl);
	}
	
    public static void main(String args[]){ 
//    	for(int i=0; i<51; i++) {
//	        addCount("rmi://10.0.11.69:8888/RCounter","icounter_test");
//    	}
    	addCount("icounter_test");
    	//clearCount("rmi://10.0.11.69:8888/RCounter","icounter_test");
    	//clearCount("all");
    	printCounter();
    } 
}
