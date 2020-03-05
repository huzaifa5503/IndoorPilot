package com.huzaifakhalid.gridviewexample;

import java.util.List;



public class Room {
    String name;
    String floor;
    String category;
    String gridnum;

    List<String> macAddressList;

    public Room(String name, String floor, String category, String gridnum, List<String> macAddressList) {
        this.name = name;
        this.floor = floor;
        this.category = category;
        this.gridnum = gridnum;
        this.macAddressList = macAddressList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGridnum() {
        return gridnum;
    }

    public void setGridnum(String gridnum) {
        this.gridnum = gridnum;
    }

    public List<String> getMacAddressList() {
        return macAddressList;
    }

    public int getNumberofMacs(){
        return macAddressList.size();
    }
    public void setMacAddressList(List<String> macAddressList) {
        this.macAddressList = macAddressList;
    }
}
