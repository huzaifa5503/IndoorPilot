package com.huzaifakhalid.gridviewexample;

import android.content.Context;
import android.graphics.Color;
import android.os.Environment;
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

import static com.huzaifakhalid.gridviewexample.R.drawable.logo1;


public class TextAdapter extends BaseAdapter {


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
        String[] fetchedMacs={"58B6330C6EC8=47","58B6330C6DF4=35","58B6330CJ788=33","58B6330C67GG=29"}; //the value of MACS and their strengths fetched from phone
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
            InputStream istream = mycontext.getAssets().open("indoor.xml");
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
                        /*
                        List<String> macList = new ArrayList<String>();

                        for (int k = 0; k < macNodeList.getLength(); k++) {
                            String temp = macNodeList.item(k).getTextContent().trim();
                            if (temp != "" && temp.length() > 12) {
                                macList.add(temp);
                            }

                        }*/


                        //roomList.add(new Room(name, floor, category, num, macList));


                       // List<String> macList = new ArrayList<String>(Arrays.asList(mac.split("\n")));



                        //macadds.add(mac);
                        /*
                        for (int u = 0 ; u < roomList.size(); u++){

                            Log.d("mylist","checklist: " + macList.get(u));

                            Log.d("roomList","roomList contains :   " + roomList.get(u).getGridnum() + "  "+ roomList.get(u).getName()+ "  " +roomList.get(u).getFloor() + "  " +roomList.get(u).getCategory() + "  " +roomList.get(u).getMacAddressList() );
                        }*/

                        //aik aur for loop
                        //store all macs in a list


                        if(Integer.parseInt(num)==IndoorData[i]){
                            Log.d("stackoverflow","values got" + num + name);
                            tv.setTextSize(15);
                            if(Integer.parseInt(num)<0){
                                tv.setBackgroundColor(Color.parseColor("#000000"));
                            }
                            else{
                                tv.setBackgroundColor(Color.parseColor("#FFFFFF"));

                            }

                            tv.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 250));

                            tv.setText(name);
                        }


                        //String city = el.getElementsByTagName("city").item(0).getTextContent();
                    }
                }
            }
           // Log.d("sizer","arraylist size is  "+  macadds.size());
           // for(int n = 0; n < macadds.size(); n++) {
               // System.out.print(macadds.get(n));
              //  Log.d("macer","arraylist is as follows  "+  macadds.get(n));

           // }

            Object[] array = macadds.toArray();
            String obj = Arrays.toString(array);
            Log.d("array","arraylist  is  "+  obj);
            Log.d("array","arraylist SIZE is  "+  obj.length());

            String[] arrOfStr2 = obj.split(",");
            Log.d("array","arraylist Split size is  "+  arrOfStr2[0]);

            String[] arrOfStrsplit={""};
            String[] arrOfStrsplitequals= {""};
            for (int check = 0 ; check < arrOfStr2.length; check++){

                 arrOfStrsplit = obj.split("\n");
                Log.d("check","arraylist after spliting is  "+  arrOfStrsplit[check]);

                for (int check1 = 0; check1 < arrOfStrsplit.length; check1++ ){

                    arrOfStrsplitequals = arrOfStrsplit[check1].split("\n");


                }


            }
            for (int r = 1 ; r < arrOfStrsplit.length;r++)
                if (r % 6 == 0 || r == arrOfStrsplit.length){

                }
            else{

                    Log.d("checkafter","arraylist after final split is"+  arrOfStrsplit[r]);

                }


            String[] arrOfStr={""};

            for(Object o : array) {
                String s = (String) o;
                int d = 0 ;
                Log.d("iter","arraylist size is  "+ s +  s.length());

               arrOfStr = s.split("=");


                d++;

            }

            for (String a: arrOfStr)
                Log.d("wwww","array contains: "+ a.length());
















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
        InputStream inputStream = mycontext.getResources().openRawResource(R.raw.indoor);
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


}

