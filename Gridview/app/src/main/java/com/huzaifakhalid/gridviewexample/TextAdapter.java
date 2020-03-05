package com.huzaifakhalid.gridviewexample;

import android.content.Context;
import android.graphics.Color;
import java.lang.*;
import android.os.Environment;
import android.provider.ContactsContract;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static com.huzaifakhalid.gridviewexample.R.drawable.logo1;


public class TextAdapter extends BaseAdapter {


    MacAddress[] macList_phone;
    Context mycontext;
    int size;

    ImageView background;
    File file = new File("D:/Semester 7/SMD/Lab11_2/Gridview/app/src/main/assets/indoor.xml");

    public TextAdapter(Context context, int size) {

        mycontext = context;
        this.size = size;


    }

    @Override
    public int getCount() {
        return size;
    }

    @Override
    public Object getItem(int i) {

        return "Room #" + i;

    }


    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Log.d("ival", "value I KIII: "+ i);
        String[] fetchedMacs={"58B6330C6EC8=47","58B6330C6DF4=35","58B6330CJ788=33","58B6330C67GG=29"}; //the value of MACS and their strengths fetched from phone
        int fetchedMacsLen=fetchedMacs.length;
        macList_phone=new MacAddress[fetchedMacsLen];
        for (int fet=0;fet<fetchedMacsLen;fet++){
            macList_phone[fet]= parseMac(fetchedMacs[fet]); // parsing data from phone on the base of "=" and saving it in Macaddress object
            Log.d("fetchlist","mac: " + macList_phone[fet].mac + "Strength: " + macList_phone[fet].strength );
        }
        String num="";
        String name="";
        String floor="";
        String category="";
        ArrayList macadds = new ArrayList<>();
        TextView tv = new TextView(mycontext);

        int[] IndoorData = readIndoorData();


        Log.d("check", "array: " + i);
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
            Log.d("length", "Gridnumfromtag " + nList.getLength());
            List<Room> roomList = new ArrayList<>();

            for (int j = 0; j < nList.getLength(); j++) {
                //Log.d("length",""+nList.getLength());
                if (nList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nList.item(j);
                    if (el.getNodeName().contains("room")) {
                        num = el.getElementsByTagName("gridnum").item(0).getTextContent();
                        Log.d("num","qwerty"+ num);
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






                           for (int z = 0 ; z < roomList.size(); z++) {

                               Log.d("maclistfrom", "Roomsize: " + roomList.size() + "list of macs : " + roomList.get(z).getMacAddressList() + "room no: " + roomList.get(z).getName());
                           }






                        if(Integer.parseInt(num)==IndoorData[i]){
                            Log.d("stackoverflow","values got" + num + name);
                            tv.setTextSize(12);
                            if(Integer.parseInt(num)<0){
                                tv.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                tv.setTextColor(Color.parseColor("#000000"));
                            }
                            else{
                                tv.setBackgroundColor(Color.parseColor("#000000"));
                                tv.setTextColor(Color.parseColor("#FFFFFF"));

                            }

                            tv.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 350));

                            if (name.equals("Path"))
                            tv.setText("");
                            else{
                                tv.setText(name);
                            }
                        }



                    }

                }

            }
            //CalculateLocation(macList_phone, roomList);














               /* if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element2 = (Element) node;
                    String gridnum = getValue("gridnum", element2, i);

                    Log.d("gridnum", "it contains: "+ gridnum);
                   // if (val ==  Integer.parseInt(gridnum) && val > 0){
                        tv.setTextSize(15);
                        tv.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        tv.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 200));
                        tv.setText(tv.getText() + "\nName : " + getValue("name", element2, i) + "\n");
                    //}
                    //Checking to see if path is found, filling it with nothing if yes
                    //else if(val ==  Integer.parseInt(gridnum) && val < 0){
                        //tv.setBackgroundColor(Color.parseColor("#000000"));
                        //tv.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 200));
                    //}






                }*/


        } catch (Exception e) {
            e.printStackTrace();
        }





    //search xml for value
        //return value into string
        //set text to string
        //tv.setText(value);
        //tv.setTextSize(10);
        //It is a room


        /*if (i % 14 == 0 || i % 14 == 1) {
            tv.setText("Room #" + i);
            tv.setTextSize(10);
            tv.setBackgroundColor(Color.parseColor("#FFFFFF"));
            tv.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 200));
            return tv;
        }
        if (i % 7 == 0 && i != 70 && i != 140 && i != 210 && i != 280) {

            tv.setText("Path");
            tv.setTextSize(10);
            tv.setBackgroundColor(Color.parseColor("#FFFFFF"));
            tv.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 200));
            return tv;
        } else {
            tv.setText("unwalkable path");
            tv.setTextSize(15);
            tv.setTextColor(Color.parseColor("#FFFFFF"));
            tv.setBackgroundColor(Color.parseColor("#000000"));
            tv.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 200));
            return tv;
        }*/


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
                //for (int i = 0 ; i < gridMap.length; i++)
                //{
                //  System.out.println("Values in the array are: " + gridMap[i]);
                //}

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


    public void CalculateLocation( MacAddress[] fetchedMacs,  List<Room> roomList){
        int totalDiff=0;
        int roomsize=roomList.size();

        int [] SumOfRoomValues=new int[roomsize]; //stores the sum of difference for each room on each index of array
        Log.d("roomsqqqqqqq", "roomssss: " + roomsize);
        for(int PhoneMac = 0 ;PhoneMac<fetchedMacs.length;PhoneMac++){
            MacAddress objMac;
            //runs till num of MACS found by phone
            for(int rooms = 0 ;rooms<roomList.size();rooms++){
                // Log.d("wert", " roomlist "+roomList.size());

                List <String> store= roomList.get(rooms).getMacAddressList();

                // Log.d("store", " storesize" + store.get(0));
                List <MacAddress> ListOfMacs = new ArrayList<>();
                for(int lister=0;lister<store.size();lister++){
                    String mac=store.get(lister);
                    Log.d("strmac", " string mac" + mac);
                    //get individual string and store here
                    //parse this string to get mac and its corresponding value differently
                    objMac = parseMac(mac);
                    Log.d("strmacobj", " string macobj" + objMac.getMac() + objMac.getStrength());
                    //return a MacAddress object
                    ListOfMacs.add(objMac); //add this mac address object into list

                }

                Log.d("roomwwwwwwww", "roomssssLIISSSIISISISI: " + ListOfMacs.size());
                for(int w=0;w<roomsize;w++) {
                    for (int x = 0; x < ListOfMacs.size(); x++) { //eg list of macs for one room is 5 so x=5
                        for (int y = 0; y < fetchedMacs.length; y++) {
                            Log.d("msg", "ListOMacs: " + ListOfMacs.get(x).getMac() + " Fetched: " + fetchedMacs[y].getMac());
                            if (ListOfMacs.get(x).getMac().equals(fetchedMacs[y].getMac())) { //if the mac of room matches mac of fetched data
                                int sum = ListOfMacs.get(x).getStrength() - fetchedMacs[y].getStrength();
                                Log.d("msgsum", "sums is: " + Math.abs(sum));
                                if (sum < 0) {
                                    totalDiff += Math.abs(sum);

                                } else {
                                    totalDiff += sum;
                                }
                            }
                        }
                        SumOfRoomValues[w] = totalDiff; //stores difference for one room
                        totalDiff = 0;
                        Log.d("tototototo", "sums is: " + totalDiff);
                    }

                }


                for(int p = 0 ; p < SumOfRoomValues.length; p++){
                    Log.d("asdf", "sumofroommssmms: "  + SumOfRoomValues[p]);
                    //ListOfMacs.get()
                }
                //after this for loop is done we will have a list (of type MacAddresses) that contains mac values for a particular room
                //                //if(fetchedMacs[PhoneMac]==ListOfMacs[//])


            }
        }
        Log.d("sumval", "xxx: "  + SumOfRoomValues.length);

            Log.d("xxx", "sumofroommssmms: "  + SumOfRoomValues[0]+SumOfRoomValues[1]+SumOfRoomValues[2]+SumOfRoomValues[3]+SumOfRoomValues[4]);
            //ListOfMacs.get()

        int lowestIndex=returnLowest(SumOfRoomValues);
        Log.d("lowest","lowestvalue :" + SumOfRoomValues[lowestIndex] + " lowestindex: "  + lowestIndex);
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


}

