package com.nuces.indoorpilot;

import java.util.ArrayList;
import java.util.List;

public class MapData {
    Room[] roomarr ;

    public MapData(int size) {
        roomarr = new Room[size];
        List<String> macList1 = new ArrayList<String>();
        macList1.add("9C741A7BA4B4=39");
        macList1.add("8C44350AFC55=24");
        macList1.add("50D2F548BCB0=44");

        List<String> macList2 = new ArrayList<String>();
        macList2.add("9C741A7BA4B4=64");
        macList2.add("8C44350AFC55=50");
        macList2.add("50D2F548BCB0=49");

        List<String> macList3 = new ArrayList<String>();
        macList3.add("9C741A7BA4B4=61");
        macList3.add("8C44350AFC55=39");
        macList3.add("50D2F548BCB0=30");

        List<String> macList4 = new ArrayList<String>();
        macList4.add("9C741A7BA4B4=51");
        macList4.add("8C44350AFC55=40");
        macList4.add("50D2F548BCB0=30");

        List<String> macList5 = new ArrayList<String>();
        macList5.add("9C741A7BA4B4=45");
        macList5.add("8C44350AFC55=47");
        macList5.add("50D2F548BCB0=59");

        List<String> macList6 = new ArrayList<String>();
        macList6.add("9C741A7BA4B4=56");
        macList6.add("8C44350AFC55=58");
        macList6.add("50D2F548BCB0=43");

        List<String> macList7 = new ArrayList<String>();
        macList7.add("9C741A7BA4B4=52");
        macList7.add("8C44350AFC55=42");
        macList7.add("50D2F548BCB0=41");

        List<String> macList8 = new ArrayList<String>();
        macList8.add("9C741A7BA4B4=51");
        macList8.add("8C44350AFC55=48");
        macList8.add("50D2F548BCB0=34");

        List<String> macList9 = new ArrayList<String>();
        macList9.add("9C741A7BA4B4=44");
        macList9.add("8C44350AFC55=46");
        macList9.add("50D2F548BCB0=29");

        List<String> macList1p = new ArrayList<String>();
        macList1p.add("9C741A7BA4B4=44");
        macList1p.add("8C44350AFC55=40");
        macList1p.add("50D2F548BCB0=44");

        List<String> macList2p = new ArrayList<String>();
        macList2p.add("9C741A7BA4B4=50");
        macList2p.add("8C44350AFC55=41");
        macList2p.add("50D2F548BCB0=73");

        List<String> macList3p = new ArrayList<String>();
        macList3p.add("9C741A7BA4B4=54");
        macList3p.add("8C44350AFC55=50");
        macList3p.add("50D2F548BCB0=40");

        List<String> macList4p = new ArrayList<String>();
        macList4p.add("9C741A7BA4B4=59");
        macList4p.add("8C44350AFC55=44");
        macList4p.add("50D2F548BCB0=35");

        List<String> macList5p = new ArrayList<String>();
        macList5p.add("9C741A7BA4B4=53");
        macList5p.add("8C44350AFC55=41");
        macList5p.add("50D2F548BCB0=34");

        List<String> macList6p = new ArrayList<String>();
        macList6p.add("9C741A7BA4B4=48");
        macList6p.add("8C44350AFC55=41");
        macList6p.add("50D2F548BCB0=26");


        roomarr[0] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[1] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[2] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[3] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[4] = new Room("Path", "1", "Path", "-1", macList1p);
        roomarr[5] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[6] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[7] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[8] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[9] = new Room("Kitchen", "1", "Kitchen", "3", macList3);
        roomarr[10] = new Room("Kitchen", "1", "Kitchen", "3", macList3);
        roomarr[11] = new Room("Kitchen", "1", "Kitchen", "3", macList3);
        roomarr[12] = new Room("Room4", "1", "Room", "4", macList4);
        roomarr[13] = new Room("Room4", "1", "Room", "4", macList4);
        roomarr[14] = new Room("Room4", "1", "Room", "4", macList4);
        roomarr[15] = new Room("Room4", "1", "Room", "4", macList4);

        roomarr[16] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[17] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[18] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[19] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[20] = new Room("Path", "1", "Path", "-1", macList1p);
        roomarr[21] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[22] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[23] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[24] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[25] = new Room("Kitchen", "1", "Kitchen", "3", macList3);
        roomarr[26] = new Room("Kitchen", "1", "Kitchen", "3", macList3);
        roomarr[27] = new Room("Kitchen", "1", "Kitchen", "3", macList3);
        roomarr[28] = new Room("Room4", "1", "Room", "4", macList4);
        roomarr[29] = new Room("Room4", "1", "Room", "4", macList4);
        roomarr[30] = new Room("Room4", "1", "Room", "4", macList4);
        roomarr[31] = new Room("Room4", "1", "Room", "4", macList4);

        roomarr[32] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[33] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[34] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[35] = new Room("Room1", "1", "Room", "1", macList1);
        roomarr[36] = new Room("Path", "1", "Path", "-1", macList1p);
        roomarr[37] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[38] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[39] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[40] = new Room("TV-Room", "1", "TvRoom", "2", macList2);
        roomarr[41] = new Room("Kitchen", "1", "Kitchen", "3", macList3);
        roomarr[42] = new Room("Kitchen", "1", "Kitchen", "3", macList3);
        roomarr[43] = new Room("Kitchen", "1", "Kitchen", "3", macList3);
        roomarr[44] = new Room("Room4", "1", "Room", "4", macList4);
        roomarr[45] = new Room("Room4", "1", "Room", "4", macList4);
        roomarr[46] = new Room("Room4", "1", "Room", "4", macList4);
        roomarr[47] = new Room("Room4", "1", "Room", "4", macList4);



        roomarr[48] = new Room("Path", "1", "Path", "-2", macList2p);
        roomarr[49] = new Room("Path", "1", "Path", "-2", macList2p);
        roomarr[50] = new Room("Path", "1", "Path", "-2", macList2p);
        roomarr[51] = new Room("Path", "1", "Path", "-2", macList2p);
        roomarr[52] = new Room("Path", "1", "Path", "-3", macList3p);
        roomarr[53] = new Room("Path", "1", "Path", "-4", macList4p);
        roomarr[54] = new Room("Path", "1", "Path", "-4", macList4p);
        roomarr[55] = new Room("Path", "1", "Path", "-4", macList4p);
        roomarr[56] = new Room("Path", "1", "Path", "-4", macList4p);
        roomarr[57] = new Room("Path", "1", "Path", "-5", macList5p);
        roomarr[58] = new Room("Path", "1", "Path", "-5", macList5p);
        roomarr[59] = new Room("Path", "1", "Path", "-5", macList5p);
        roomarr[60] = new Room("Path", "1", "Path", "-6", macList6p);
        roomarr[61] = new Room("Path", "1", "Path", "-6", macList6p);
        roomarr[62] = new Room("Path", "1", "Path", "-6", macList6p);
        roomarr[63] = new Room("Path", "1", "Path", "-6", macList6p);

        roomarr[64] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[65] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[66] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[67] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[68] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[69] = new Room("Dining-Room", "1", "Dining", "6", macList6);
        roomarr[70] = new Room("Dining-Room", "1", "Dining", "6", macList6);
        roomarr[71] = new Room("Room7", "1", "Room", "7", macList7);
        roomarr[72] = new Room("Room7", "1", "Room", "7", macList7);
        roomarr[73] = new Room("Store", "1", "Store", "8", macList8);
        roomarr[74] = new Room("Store", "1", "Store", "8", macList8);
        roomarr[75] = new Room("Store", "1", "Store", "8", macList8);
        roomarr[76] = new Room("Room9", "1", "Room", "9", macList9);
        roomarr[77] = new Room("Room9", "1", "Room", "9", macList9);
        roomarr[78] = new Room("Room9", "1", "Room", "9", macList9);
        roomarr[79] = new Room("Room9", "1", "Room", "9", macList9);

        roomarr[80] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[81] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[82] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[83] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[84] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[85] = new Room("Dining-Room", "1", "Dining", "6", macList6);
        roomarr[86] = new Room("Dining-Room", "1", "Dining", "6", macList6);
        roomarr[87] = new Room("Room7", "1", "Room", "7", macList7);
        roomarr[88] = new Room("Room7", "1", "Room", "7", macList7);
        roomarr[89] = new Room("Store", "1", "Store", "8", macList8);
        roomarr[90] = new Room("Store", "1", "Store", "8", macList8);
        roomarr[91] = new Room("Store", "1", "Store", "8", macList8);
        roomarr[92] = new Room("Room9", "1", "Room", "9", macList9);
        roomarr[93] = new Room("Room9", "1", "Room", "9", macList9);
        roomarr[94] = new Room("Room9", "1", "Room", "9", macList9);
        roomarr[95] = new Room("Room9", "1", "Room", "9", macList9);

        roomarr[96] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[97] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[98] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[99] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[100] = new Room("Drawing-Room", "1", "Drawing", "5", macList5);
        roomarr[101] = new Room("Dining-Room", "1", "Dining", "6", macList6);
        roomarr[102] = new Room("Dining-Room", "1", "Dining", "6", macList6);
        roomarr[103] = new Room("Room7", "1", "Room", "7", macList7);
        roomarr[104] = new Room("Room7", "1", "Room", "7", macList7);
        roomarr[105] = new Room("Store", "1", "Store", "8", macList8);
        roomarr[106] = new Room("Store", "1", "Store", "8", macList8);
        roomarr[107] = new Room("Store", "1", "Store", "8", macList8);
        roomarr[108] = new Room("Room9", "1", "Room", "9", macList9);
        roomarr[109] = new Room("Room9", "1", "Room", "9", macList9);
        roomarr[110] = new Room("Room9", "1", "Room", "9", macList9);
        roomarr[111] = new Room("Room9", "1", "Room", "9", macList9);


    }

    public Room[] getRoomarr() {
        return roomarr;
    }
}
