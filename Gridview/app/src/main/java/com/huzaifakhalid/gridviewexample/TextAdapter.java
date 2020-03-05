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
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static com.huzaifakhalid.gridviewexample.R.drawable.logo1;


public class TextAdapter extends BaseAdapter {


    MacAddress[] macList_phone;
    Context mycontext;
    int size;
    Room[] roomarr ;



    ImageView background;
    File file = new File("D:/Semester 7/SMD/Lab11_2/Gridview/app/src/main/assets/indoor.xml");

    public TextAdapter(Context context, int size) {

        mycontext = context;
        this.size = size;
        roomarr = new Room[size];
        List<String> macList = new ArrayList<String>();
        macList.add("58B6330C6EC8=45");
        macList.add("58B6330C6DF4=40");
        macList.add("58B6330CJ788=35");
        macList.add("58B6330C67GG=30");
        macList.add("58B6330C0099=20");

        roomarr[0] = new Room("N-01", "1", "Class", "1", macList);
        roomarr[1] = new Room("N-01", "1", "Class", "1", macList);
        roomarr[2] = new Room("N-01A", "1", "Class", "2", macList);
        roomarr[3] = new Room("N-01A", "1", "Class", "2", macList);
        roomarr[4] = new Room("N-02", "1", "Class", "3", macList);
        roomarr[5] = new Room("N-02", "1", "Class", "3", macList);
        roomarr[6] = new Room("N-02A", "1", "Class", "4", macList);
        roomarr[7] = new Room("N-02A", "1", "Class", "4", macList);
        roomarr[8] = new Room("N-03", "1", "Class", "5", macList);
        roomarr[9] = new Room("N-03", "1", "Class", "5", macList);
        roomarr[10] = new Room("N-03A", "1", "Class", "6", macList);
        roomarr[11] = new Room("N-03A", "1", "Class", "6", macList);
        roomarr[12] = new Room("N-04", "1", "Class", "7", macList);
        roomarr[13] = new Room("N-04", "1", "Class", "7", macList);
        roomarr[14] = new Room("N-04A", "1", "Class", "8", macList);
        roomarr[15] = new Room("N-04A", "1", "Class", "8", macList);
        roomarr[16] = new Room("Path", "1", "Path", "-9", macList);
        roomarr[17] = new Room("Path", "1", "Path", "-9", macList);
        roomarr[18] = new Room("Path", "1", "Path", "-10", macList);
        roomarr[19] = new Room("Path", "1", "Path", "-10", macList);
        roomarr[20] = new Room("N-08", "1", "Office", "11", macList);
        roomarr[21] = new Room("N-08", "1", "Office", "11", macList);
        roomarr[22] = new Room("N-09", "1", "Office", "12", macList);
        roomarr[23] = new Room("N-09", "1", "Office", "12", macList);
        roomarr[24] = new Room("N-09A", "1", "Office", "13", macList);
        roomarr[25] = new Room("N-09A", "1", "Office", "13", macList);
        roomarr[26] = new Room("Ladies Room", "1", "Washroom", "14", macList);
        roomarr[27] = new Room("Ladies Room", "1", "Washroom", "14", macList);
        roomarr[28] = new Room("Mens Room", "1", "Washroom", "15", macList);
        roomarr[29] = new Room("Mens Room", "1", "Washroom", "15", macList);
        roomarr[30] = new Room("Auditorium", "1", "Auditorium", "16", macList);
        roomarr[31] = new Room("Auditorium", "1", "Auditorium", "16", macList);

        roomarr[32] = new Room("N-01", "1", "Class", "1", macList);
        roomarr[33] = new Room("N-01", "1", "Class", "1", macList);
        roomarr[34] = new Room("N-01A", "1", "Class", "2", macList);
        roomarr[35] = new Room("N-01A", "1", "Class", "2", macList);
        roomarr[36] = new Room("N-02", "1", "Class", "3", macList);
        roomarr[37] = new Room("N-02", "1", "Class", "3", macList);
        roomarr[38] = new Room("N-02A", "1", "Class", "4", macList);
        roomarr[39] = new Room("N-02A", "1", "Class", "4", macList);
        roomarr[40] = new Room("N-03", "1", "Class", "5", macList);
        roomarr[41] = new Room("N-03", "1", "Class", "5", macList);
        roomarr[42] = new Room("N-03A", "1", "Class", "6", macList);
        roomarr[43] = new Room("N-03A", "1", "Class", "6", macList);
        roomarr[44] = new Room("N-04", "1", "Class", "7", macList);
        roomarr[45] = new Room("N-04", "1", "Class", "7", macList);
        roomarr[46] = new Room("N-04A", "1", "Class", "8", macList);
        roomarr[47] = new Room("N-04A", "1", "Class", "8", macList);
        roomarr[48] = new Room("Path", "1", "Path", "-9", macList);
        roomarr[49] = new Room("Path", "1", "Path", "-9", macList);
        roomarr[50] = new Room("Path", "1", "Path", "-10", macList);
        roomarr[51] = new Room("Path", "1", "Path", "-10", macList);
        roomarr[52] = new Room("N-08", "1", "Office", "11", macList);
        roomarr[53] = new Room("N-08", "1", "Office", "11", macList);
        roomarr[54] = new Room("N-09", "1", "Office", "12", macList);
        roomarr[55] = new Room("N-09", "1", "Office", "12", macList);
        roomarr[56] = new Room("N-09A", "1", "Office", "13", macList);
        roomarr[57] = new Room("N-09A", "1", "Office", "13", macList);
        roomarr[58] = new Room("Ladies Room", "1", "Washroom", "14", macList);
        roomarr[59] = new Room("Ladies Room", "1", "Washroom", "14", macList);
        roomarr[60] = new Room("Mens Room", "1", "Washroom", "15", macList);
        roomarr[61] = new Room("Mens Room", "1", "Washroom", "15", macList);
        roomarr[62] = new Room("Auditorium", "1", "Auditorium", "16", macList);
        roomarr[63] = new Room("Auditorium", "1", "Auditorium", "16", macList);

        roomarr[64] = new Room("Path", "1", "Path", "-1", macList);
        roomarr[65] = new Room("Path", "1", "Path", "-1", macList);
        roomarr[66] = new Room("Path", "1", "Path", "-2", macList);
        roomarr[67] = new Room("Path", "1", "Path", "-2", macList);
        roomarr[68] = new Room("Path", "1", "Path", "-3", macList);
        roomarr[69] = new Room("Path", "1", "Path", "-3", macList);
        roomarr[70] = new Room("Path", "1", "Path", "-4", macList);
        roomarr[71] = new Room("Path", "1", "Path", "-4", macList);
        roomarr[72] = new Room("Path", "1", "Path", "-5", macList);
        roomarr[73] = new Room("Path", "1", "Path", "-5", macList);
        roomarr[74] = new Room("Path", "1", "Path", "-6", macList);
        roomarr[75] = new Room("Path", "1", "Path", "-6", macList);
        roomarr[76] = new Room("Path", "1", "Path", "-7", macList);
        roomarr[77] = new Room("Path", "1", "Path", "-7", macList);
        roomarr[78] = new Room("Path", "1", "Path", "-8", macList);
        roomarr[79] = new Room("Path", "1", "Path", "-8", macList);
        roomarr[80] = new Room("Path", "1", "Path", "-9", macList);
        roomarr[81] = new Room("Path", "1", "Path", "-9", macList);
        roomarr[82] = new Room("Path", "1", "Path", "-10", macList);
        roomarr[83] = new Room("Path", "1", "Path", "-10", macList);
        roomarr[84] = new Room("Path", "1", "Path", "-11", macList);
        roomarr[85] = new Room("Path", "1", "Path", "-11", macList);
        roomarr[86] = new Room("Path", "1", "Path", "-12", macList);
        roomarr[87] = new Room("Path", "1", "Path", "-12", macList);
        roomarr[88] = new Room("Path", "1", "Path", "-13", macList);
        roomarr[89] = new Room("Path", "1", "Path", "-13", macList);
        roomarr[90] = new Room("Path", "1", "Path", "-14", macList);
        roomarr[91] = new Room("Path", "1", "Path", "-14", macList);
        roomarr[92] = new Room("Path", "1", "Path", "-15", macList);
        roomarr[93] = new Room("Path", "1", "Path", "-15", macList);
        roomarr[94] = new Room("Auditorium", "1", "Auditorium", "17", macList);
        roomarr[95] = new Room("Auditorium", "1", "Auditorium", "17", macList);

        roomarr[96]  = new Room("N-07", "1", "Admin", "18", macList);
        roomarr[97]  = new Room("N-07", "1", "Admin", "18", macList);
        roomarr[98]  = new Room("N-07", "1", "Admin", "19", macList);
        roomarr[99]  = new Room("N-07", "1", "Admin", "19", macList);
        roomarr[100] = new Room("N-07A", "1", "Admin", "20", macList);
        roomarr[101] = new Room("N-07A", "1", "Admin", "20", macList);
        roomarr[102] = new Room("N-07A", "1", "Admin", "21", macList);
        roomarr[103] = new Room("N-07A", "1", "Admin", "21", macList);
        roomarr[104] = new Room("N-07B", "1", "Admin", "22", macList);
        roomarr[105] = new Room("N-07B", "1", "Admin", "22", macList);
        roomarr[106] = new Room("N-05A", "1", "Admin", "23", macList);
        roomarr[107] = new Room("N-05A", "1", "Admin", "23", macList);
        roomarr[108] = new Room("N-05A", "1", "Admin", "24", macList);
        roomarr[109] = new Room("N-05A", "1", "Admin", "24", macList);
        roomarr[110] = new Room("N-05", "1", "Admin", "25", macList);
        roomarr[111] = new Room("N-05", "1", "Admin", "25", macList);
        roomarr[112] = new Room("Path", "1", "Path", "-16", macList);
        roomarr[113] = new Room("Path", "1", "Path", "-16", macList);
        roomarr[114] = new Room("Path", "1", "Path", "-17", macList);
        roomarr[115] = new Room("Path", "1", "Path", "-17", macList);
        roomarr[116] = new Room("N-13B", "1", "Class", "26", macList);
        roomarr[117] = new Room("N-13B", "1", "Class", "26", macList);
        roomarr[118] = new Room("N-13B", "1", "Class", "27", macList);
        roomarr[119] = new Room("N-13B", "1", "Class", "27", macList);
        roomarr[120] = new Room("Girls Common Room", "1", "Class", "28", macList);
        roomarr[121] = new Room("Girls Common Room", "1", "Class", "28", macList);
        roomarr[122] = new Room("N-13", "1", "Class", "29", macList);
        roomarr[123] = new Room("N-13", "1", "Class", "29", macList);
        roomarr[124] = new Room("N-12", "1", "Class", "30", macList);
        roomarr[125] = new Room("N-12", "1", "Class", "30", macList);
        roomarr[126] = new Room("Auditorium", "1", "Auditorium", "31", macList);
        roomarr[127] = new Room("Auditorium", "1", "Auditorium", "31", macList);

        roomarr[128] = new Room("N-07", "1", "Class", "18", macList);
        roomarr[129] = new Room("N-07", "1", "Class", "18", macList);
        roomarr[130] = new Room("N-07", "1", "Class", "19", macList);
        roomarr[131] = new Room("N-07", "1", "Class", "19", macList);
        roomarr[132] = new Room("N-07A", "1", "Class", "20", macList);
        roomarr[133] = new Room("N-07A", "1", "Class", "20", macList);
        roomarr[134] = new Room("N-07A", "1", "Class", "21", macList);
        roomarr[135] = new Room("N-07A", "1", "Class", "21", macList);
        roomarr[136] = new Room("N-07B", "1", "Class", "22", macList);
        roomarr[137] = new Room("N-07B", "1", "Class", "22", macList);
        roomarr[138] = new Room("N-05A", "1", "Admin", "23", macList);
        roomarr[139] = new Room("N-05A", "1", "Admin", "23", macList);
        roomarr[140] = new Room("N-05A", "1", "Admin", "24", macList);
        roomarr[141] = new Room("N-05A", "1", "Admin", "24", macList);
        roomarr[142] = new Room("N-05", "1", "Admin", "25", macList);
        roomarr[143] = new Room("N-05", "1", "Admin", "25", macList);
        roomarr[144] = new Room("Path", "1", "Path", "-16", macList);
        roomarr[145] = new Room("Path", "1", "Path", "-16", macList);
        roomarr[146] = new Room("Path", "1", "Path", "-17", macList);
        roomarr[147] = new Room("Path", "1", "Path", "-17", macList);
        roomarr[148] = new Room("N-13B", "1", "Class", "26", macList);
        roomarr[149] = new Room("N-13B", "1", "Class", "26", macList);
        roomarr[150] = new Room("N-13B", "1", "Class", "27", macList);
        roomarr[151] = new Room("N-13B", "1", "Class", "27", macList);
        roomarr[152] = new Room("Girls Common Room", "1", "Class", "28", macList);
        roomarr[153] = new Room("Girls Common Room", "1", "Class", "28", macList);
        roomarr[154] = new Room("N-13", "1", "Class", "29", macList);
        roomarr[155] = new Room("N-13", "1", "Class", "29", macList);
        roomarr[156] = new Room("N-12", "1", "Class", "30", macList);
        roomarr[157] = new Room("N-12", "1", "Class", "30", macList);
        roomarr[158] = new Room("Auditorium", "1", "Auditorium", "31", macList);
        roomarr[159] = new Room("Auditorium", "1", "Auditorium", "31", macList);






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

        Log.d("iszie", "value I sizzzz: "+ roomarr.length);
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

                            if (name.equals("Path")) {

                                tv.setText("");
                            }
                            else{
                                tv.setText(name);
                            }
                        }




                    }


                }


            }

            if(i>=getCount()-1){
                CalculateLocation(macList_phone, roomList);
               // displayVals(roomarr);
            }

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

   /* public void displayVals(Room[]  arr){
        for(int i=0;i<arr.length;i++){
            Log.d("CHECKING", "ayeehehe: "+ roomarr[i].getCategory()+
                    roomarr[i].getFloor()+
                    roomarr[i].getGridnum()+
                    roomarr[i].getMacAddressList()+
                    roomarr[i].getName());
        }
    }
*/

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

        for(int i=0;i<sumofRoomvals.length;i++){
            Log.d("lowest","lowestvalue :" + sumofRoomvals[i]) ;
        }

        //int lowestIndex=returnLowest(sumofRoomvals);
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


}

