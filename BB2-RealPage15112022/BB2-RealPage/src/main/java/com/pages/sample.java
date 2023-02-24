package com.pages;


import com.aspose.cells.Workbook;


public class sample {

    public static void main(String args[]) throws Exception {
       String s = "4.90";
        int totalrent_Size = String.valueOf(s).length();
        System.out.println(totalrent_Size);
        if(String.valueOf(s).substring(totalrent_Size-1,totalrent_Size).contains("0")){
            s = s.substring(0,totalrent_Size-1);

        }
        System.out.println(s);


    }
}
