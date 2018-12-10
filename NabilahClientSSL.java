/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nabilahclientssl;

import java.io.*;
import javax.net.ssl.*;

public class NabilahClientSSL {

 public static final boolean DEBUG = true;
 public static final int HTTPS_PORT = 443;
 public static final String HTTPS_HOST = "localhost";//localhost
 public static final String TRUSTTORE_LOCATION = "C:\\Program Files\\Java\\jdk1.8.0_181\\bin\\secNabilah.jks";

    public static void main(String[] args) {
         System.setProperty("javax.net.ssl.trustStore", TRUSTTORE_LOCATION);

 if (DEBUG)System.setProperty("javax.net.debug", "ssl:record");

 SSLSocketFactory f = (SSLSocketFactory) SSLSocketFactory.getDefault();
 try {
 SSLSocket c = (SSLSocket) f.createSocket(HTTPS_HOST, HTTPS_PORT);

 c.startHandshake();
 BufferedWriter w = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
 BufferedReader r = new BufferedReader(new InputStreamReader(c.getInputStream()));
 String msg = "Hey, here is client, how are you?";
 w.write(msg, 0, msg.length());
 w.newLine();
 w.flush();

 // now read the socket
 String m = null;
 while ((m = r.readLine()) != null) {
 System.out.println(m);
 }

 } catch (IOException e) {
 System.err.println(e.toString());
 }

 }
}

        // TODO code application logic here
 
