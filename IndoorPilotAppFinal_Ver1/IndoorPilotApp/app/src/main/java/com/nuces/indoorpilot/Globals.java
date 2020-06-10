package com.nuces.indoorpilot;

public class Globals{
    private static Globals instance;

    // Global variable
    int sentfromhometoscan=0;
    int numtimeshome=0;
    int scandone=0;
    String searchMap="";
    String [] wifiInfo;

    // Restrict the constructor from being instantiated
    private Globals(){}

    public void setData(String [] wifiinfo){
        this.wifiInfo=wifiinfo;
    }
    public void setVar(int n){
        this.sentfromhometoscan=n;
    }
    public void setVarScan(int n){
        this.scandone=n;
    }
    public void setVarSearch(String str){
        this.searchMap=str;
    }
    public void setVarHome(int n){
        this.numtimeshome=n;
    }
    public int getVar(){
        return this.sentfromhometoscan;
    }
    public int getVarScan(){
        return this.scandone;
    }
    public int getVarHome(){
        return this.numtimeshome;
    }
    public String getVarSearch(){
        return this.searchMap;
    }
    public String[] getData(){
        return this.wifiInfo;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}