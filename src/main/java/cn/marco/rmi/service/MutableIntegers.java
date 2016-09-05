package cn.marco.rmi.service;

public class MutableIntegers{  
    private int val;  
    public MutableIntegers(int val){  
        this.val = val;  
    }  
    public int get(){  
        return this.val;  
    }  
    public void set(int val){  
        this.val = val;  
    }  
    // 为了方便打印  
    public String toString() {  
        return Integer.toString(val);  
    }  
}  
