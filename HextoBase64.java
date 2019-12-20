/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextobase64;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Undefined
 */
public class HextoBase64 {

    static char[] hexTable = "0123456789abcdef".toCharArray();
    static char[] baseTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    
    public static void main(String[] args) throws MalformedURLException, IOException {
    
    String x,y, crypt;
   // x = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
    x = "1c0111001f010100061a024b53535009181c";
    y = "686974207468652062756c6c277320657965";
    crypt = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
    

    char[] hexTable = "0123456789abcdef".toCharArray();
    char[] baseTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    
    URL url = new URL("https://cryptopals.com/static/challenge-data/4.txt");
    Scanner s = new Scanner(url.openStream());
    
    int b1=0;
    int b2 = 0;
    int b3;
    int[] binOne;
    int[] sexTet = new int[6];
    String str;
    int dec;

    
    ArrayList <Integer> XOR = new ArrayList<Integer>();
    ArrayList <Integer> bigBin = new ArrayList<Integer>();

char[] hexString = x.toCharArray();
int[] digits = new int[x.length()];

for(int i = 0; i < hexString.length;i++)
{
  for (int j = 0;j<16;j++){
      if (hexString[i]== hexTable[j]){
          digits[i] = j;
          //System.out.print(digits[i]+ " ");
  }
  }
    }
System.out.println();
System.out.println("Hex Input: "+x);
System.out.print("Binary Values: ");
for(int i =0; i<digits.length;i++){
    if(i%2 ==0 ){
        b1 = digits[i]<<4;
    }
    else{ b2 = digits[i];
    b3 = b1^b2;
 
    XOR.add(b3);
    binOne = BinArray(b3);
    PrintBin(binOne);
    addToBigBin(binOne,bigBin);
    }
}
for(int i = 0;i<bigBin.size();i++){
   //System.out.print(bigBin.get(i));
}

//getSextet(sexTet,bigBin);
ArrayList <Integer> decimals = getSextet(bigBin);
System.out.println();
System.out.print("Base 64 Encoding: ");
for(int i = 0; i<decimals.size();i++){
   System.out.print(baseTable[decimals.get(i)]);
}
System.out.println();

//int[] xArray = HexToDec(x.toCharArray());
//int[] yArray = HexToDec(y.toCharArray());

//int[]xor = XORBytes(xArray,yArray);

int[]cryptArray = HexToDec(crypt.toCharArray());
System.out.println();

//System.out.println(encryptDecrypt(crypt, 'A'));
System.out.println(crypt.length());
byte[]b = crypt.getBytes();
System.out.println(b.length);
System.out.println();
//System.out.println((char)55^'X');
//HexDec(crypt);
//printScan(s);
for(int i = 0;i<255;i++){
    ScanCrypt(s,i);
}
    }
public static int[] BinArray(int x){
    int[] Bin = new int[8];
    for(int i = 0; i <8;i++){
        Bin[i]= x%2;
        x/=2;
    }
    return Bin;
}
public static void PrintBin(int[]x){
     for(int i = 7;i >= 0;i--){
       System.out.print(x[i]);
     }
}

public static void addToBigBin(int[]x, ArrayList<Integer>bin){
        for(int i = 7;i >= 0;i--){
      bin.add(x[i]);
     } 
}
public static ArrayList<Integer>getSextet(ArrayList<Integer>bigBin){
    ArrayList<Integer> decVal = new ArrayList<Integer>();
    String sex;
    int dec;
    for(int i = 0; i<bigBin.size();i++){
        if(i%6==0){
            sex = ""+bigBin.get(i)+""+bigBin.get(i+1)+""+bigBin.get(i+2)+""+bigBin.get(i+3)+""+bigBin.get(i+4)+""+bigBin.get(i+5);
            //System.out.print(sex+" ");
           dec = Integer.parseInt(sex, 2);
         //  System.out.print(dec+" ");
           decVal.add(dec);
        }
    }
    
    return decVal;
}
public static int[] HexToDec(char[]hexString){
    int[]digits = new int[hexString.length];
    for(int i = 0; i < hexString.length;i++)
{
  for (int j = 0;j<16;j++){
      if (hexString[i]== hexTable[j]){
          digits[i] = j;
         // System.out.print(digits[i]+ " ");
  }
  }
    }
    
    
    return digits;  
}
public static int[] XORBytes(int[]xArray, int[] yArray){
    int [] xor = new int[xArray.length];
    for(int i = 0;i<xor.length;i++){
        xor[i] = xArray[i]^yArray[i];
       // System.out.print(xor[i]+ " ");
    }
    return xor;
}

public static void printHex(int[] dec){
    for(int i =0; i < dec.length;i++){
        if(dec[i]<=9){
            System.out.print(dec[i]);
        }
        if(dec[i]>9){
            if(dec[i]==10){
                System.out.print("A");
            }
                        if(dec[i]==11){
                System.out.print("B");
            }
                                    if(dec[i]==12){
                System.out.print("C");
            }
                                                if(dec[i]==13){
                System.out.print("D");
            }
                                                            if(dec[i]==14){
                System.out.print("E");
            }
                                                                        if(dec[i]==15){
                System.out.print("F");
            }
        }
    }
    System.out.println();
}
public static int[] XORBytes(int[]xArray, int test){
    int [] xor = new int[xArray.length];
    for(int i = 0;i<xor.length;i++){
        xor[i] = xArray[i]^test;
        System.out.print(xor[i]+ " ");
    }
    System.out.println();
    return xor;
}
public static void base64Print(int[]decimals){
    for(int i = 0; i<decimals.length;i++){
   System.out.print(baseTable[decimals[i]]);
}
}
    
    public static int[] HexDec(String s){
        int sum  =0;
        int index = 0;
        char[] strings = s.toCharArray();
        int[] hex = HexToDec(strings);
        int[]b = new int[hex.length/2];
        
        for(int i = 0; i<hex.length; i++){
           if(i%2==0){
               sum = 0;
               sum+=hex[i]*16;
           } 
           if(i%2==1){
               sum+=hex[i];
               b[index]=sum;
               index++;
               //System.out.print(sum+ " ");
               
               
           }
        }
        return b;
    }
    
    public static void printScan(Scanner s){
        while(s.hasNext()){
            System.out.println(s.next());
        }
    }
    public static void ScanCrypt(Scanner s, int m){
      String x;
     
      while(s.hasNext()){
      x = s.next();
      int [] xord = HexDec(x);
      
      for(int i = 0; i <xord.length;i++){
        System.out.print((xord[i]^m)+" ");
       
      }
      System.out.println();
      }
      
    }
}
