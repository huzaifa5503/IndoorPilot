package com.nuces.indoorpilot;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class TextAdapter extends BaseAdapter {





    Context mycontext;
    List<Room> roomList = new ArrayList<>();
    int foundSearch;
    int size;
    int low;
    boolean lowUpdated=false;
    Room[] roomarr ;
    String[] fetchedMacs; //the value of MACS and their strengths fetched from phone
    //String [] fetchedMacs={"9C741A7BA4B4=54","8C44350AFC55=49","50D2F548BCB0=35","58B6330CJ788=30","58B6330C67GG=29"};
    int fetchedMacsLen;
    MacAddress[] macList_phone;


    public TextAdapter(Context context, int size) {
        Globals ver=Globals.getInstance();
        fetchedMacs=ver.getData();
        fetchedMacsLen=fetchedMacs.length;
        for(int i=0;i<fetchedMacs.length;i++) {
            Log.d("WifiInfo", fetchedMacs[i]);
        }
        macList_phone=new MacAddress[fetchedMacsLen];
        mycontext = context;
        this.size = size;
        MapData mpdata=new MapData(size);
        roomarr=mpdata.getRoomarr();
    }


    @Override
    public int getCount() {
        return size;
    }

    @Override
    public Object getItem(int i) {

        return "Room #" + i +" Category: "+" Floor: " + "Timings: "+"Person: ";

    }


    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        SaveinList(fetchedMacs,macList_phone);
        String num="";
        String name="";
        String floor="";
        String category="";
        ArrayList macadds = new ArrayList<>();
        TextView tv = new TextView(mycontext);
        if(i==0){
            low=CalculateLocation(macList_phone, roomList);
        }

        int[] IndoorData = readIndoorData();


        //Log.d("check", "array: " + i);
        int val = IndoorData[i];
        String value = Integer.toString(val);
        try {
            ArrayList<HashMap<String, String>> userList = new ArrayList<>();
            InputStream istream = mycontext.getAssets().open("check.xml");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(istream);
            NodeList nList = doc.getElementsByTagName("room");
            Node node = nList.item(i);
            //Log.d("length", "Gridnumfromtag " + nList.getLength());


            for (int j = 0; j < nList.getLength(); j++) {
                //Log.d("length",""+nList.getLength());
                if (nList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nList.item(j);
                    if (el.getNodeName().contains("room")) {
                        num = el.getElementsByTagName("gridnum").item(0).getTextContent();
                        //Log.d("num","qwerty"+ num);
                        name = el.getElementsByTagName("name").item(0).getTextContent();
                        floor = el.getElementsByTagName("floor").item(0).getTextContent();
                        category = el.getElementsByTagName("category").item(0).getTextContent();

                        NodeList macNodeList = el.getElementsByTagName("mac-addresses").item(0).getChildNodes();

                        List<String> macList = new ArrayList<String>();

                        for (int k = 0; k < macNodeList.getLength(); k++) {
                            String temp = macNodeList.item(k).getTextContent().trim();
                            if (temp != "" && temp.length() > 12) {
                                macList.add(temp);
                            }
                        }

                        roomList.add(new Room(name, floor, category, num, macList));
                        Globals varSearch =Globals.getInstance();

                        String nameaa = varSearch.getVarSearch();
                        for (int g = 0 ; g < roomList.size(); g++){

                            if (nameaa.equals(roomList.get(g).getName())){
                                Log.d("ABCDE", "Name found... At gridnum: "+ nameaa+ "... "+ roomList.get(g).getGridnum());
                            }
                        }

                        foundSearch = SearchinMap( nameaa, roomList); //returns the gridnum of searched room. and -1 if not found}
                        //Log.d("SEARCH", "foundatGrid: "+ " found"+ " "+ foundSearch);
                        if(Integer.parseInt(num)==IndoorData[i]){
                            //Log.d("stackoverflow","values got" + num + name);
                            tv.setTextSize(12);
                            if(Integer.parseInt(num)<0){
                                tv.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                tv.setTextColor(Color.parseColor("#000000"));
                            }
                            else{
                                tv.setBackgroundColor(Color.parseColor("#ADD8E6"));
                                tv.setTextColor(Color.parseColor("#000000"));

                            }

                            tv.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 300));

                            if (name.equals("Path")&&category.equals("Path")) {
                                tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.stephor, 0, 0, 0);
                                //tv.setText("");
                            }
                            else{

                                if(category.equals("Room")) {
                                    tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.room);
                                }
                                else if(category.equals("PathUp")){
                                    tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.steps);
                                }
                                else if(category.equals("TvRoom")){
                                    tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.tv_icon);
                                }
                                else if(category.equals("Kitchen")){
                                    tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.kitchen);
                                }
                                else if(category.equals("Store")){
                                    tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.store);
                                }
                                else if(category.equals("Dining")){
                                    tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.dining);
                                }
                                else if(category.equals("Drawing")){
                                    tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.drawing);
                                }


                                tv.setText(name);
                            }
                            if(i==low){ //if found matching data
                                tv.setText("You are here!");
                                tv.setBackgroundColor(Color.parseColor("#FF0000"));
                            }
                            if(Integer.parseInt(num) == foundSearch){ //if found matching data
                                //tv.setText("DESTINATION!");
                                tv.setBackgroundColor(Color.parseColor("#008000"));

                            }
                        }




                    }


                }


            }

            //if(i>=getCount()/2){


            //}

        } catch (Exception e) {
            e.printStackTrace();
        }



        return tv;
    }


    public int[] readIndoorData() {
        int[] gridMap = new int[size];
        Log.d("TAG", "GridMap: " + gridMap.length);

        String linesfromfile = "";
        String[] token = {""};
        InputStream inputStream = mycontext.getResources().openRawResource(R.raw.fast_building);
        BufferedReader inputreader = new BufferedReader(
                new InputStreamReader(inputStream, Charset.forName("UTF-8"))
        );
        int reference = 0;
        try {
            while ((linesfromfile = inputreader.readLine()) != null) {
                token = linesfromfile.split(",");
                Log.d("TAG", "Lines from line: " + token[0]);

                for (int i = 0; i < token.length; i++) {

                    gridMap[reference] = Integer.parseInt(token[i]);
                    reference++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gridMap;
    }


    private static String getValue(String tag, Element element, int val) {
        NodeList nodeList = element.getElementsByTagName(tag).item(val).getChildNodes();
        Node node = nodeList.item(val);
        return node.getNodeValue();
    }


    protected String getNodeValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        Node node = nodeList.item(0);
        if(node!=null){
            if(node.hasChildNodes()){
                Node child = node.getFirstChild();
                while (child!=null){
                    if(child.getNodeType() == Node.TEXT_NODE){
                        return  child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }


    public MacAddress parseMac(String a){

        MacAddress macadd = new MacAddress();
        String[] parsing = a.split("=");
        macadd.mac = parsing[0];
        macadd.strength = Integer.parseInt(parsing[1]);
        Log.d("parse", "str1"+ macadd.mac + "str2" + macadd.strength);
        return macadd;



    }


    public int CalculateLocation( MacAddress[] fetchedMacs,  List<Room> roomList){
        int roomsize= getCount(); //this is the size of the grid example 32x5 = 160
        int [] sumofRoomvals = new int [roomsize];
        int sum; //this is the variable to store the sum calculated for each grid cell
        for (int i=0;i<roomsize;i++){ //this will run for each grid in the gridview
            sum=0;
            for(int x=0;x<fetchedMacs.length;x++){ //this loop will search each wifi MAC with the list in each grid of array
                String MacOfRecvd=fetchedMacs[x].getMac();
                int value=fetchedMacs[x].getStrength();
                boolean ifFound=false;
                for(int y=0;y<roomarr[i].getNumberofMacs();y++){ //search one particular Mac of Recieved list with the entire list of MACS in Room List
                    List <String> recvList = roomarr[i].getMacAddressList();
                    MacAddress newobj = parseMac(recvList.get(y));
                    if(MacOfRecvd.equals(newobj.getMac())){
                        ifFound=true;
                        int sumOf=value-newobj.getStrength();
                        if (sumOf < 0) {
                            sum += Math.abs(sumOf);

                        } else {
                            sum += sumOf;
                        }
                    }
                }
                if(ifFound!=true){
                    sum+=10;//error correction
                }
            }
            sumofRoomvals[i]=sum;
        }

        /*for(int i=0;i<sumofRoomvals.length;i++){
            Log.d("lowest","lowestvalue :" + sumofRoomvals[i]) ;
        }*/

        int lowestIndex=returnLowest(sumofRoomvals);
        return  lowestIndex;
        //Log.d("lowest","lowestvalue :" + SumOfRoomValues[lowestIndex] + " lowestindex: "  + lowestIndex);
    }


    public int returnLowest(int[] arr){ //returns the index of the lowest element in the array
        int lowest=9999;
        int lowestIndex=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<lowest){
                lowest=arr[i];
                lowestIndex=i;
            }
        }
        return lowestIndex;
    }

    public void SaveinList(String [] arr1, MacAddress [] arr2){
        for (int fet=0;fet<arr1.length;fet++){
            arr2[fet]= parseMac(arr1[fet]); // parsing data from phone on the base of "=" and saving it in Macaddress object
        }
    }

    public int SearchinMap(String name, List<Room> roomList){



        for (int g = 0 ; g < roomList.size(); g++){

            if (name.equals(roomList.get(g).getName())){
                Log.d("ABCDE", "Name found... At gridnum: "+ name+ "... "+ roomList.get(g).getGridnum());
                return Integer.parseInt(roomList.get(g).getGridnum());
            }

        }
        return -10;
    }


}

