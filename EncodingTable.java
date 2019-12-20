package hextobase64;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Undefined
 */
public class EncodingTable {
String hexString = "0123456789abcdef";
String base64String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
         
    char [] HexTable;
    char [] Base64Table;

  EncodingTable(){
    char [] HexTable = hexString.toCharArray();
    char [] Base64Table = base64String.toCharArray();
}
}

