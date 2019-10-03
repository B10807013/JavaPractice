package udpClient.exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args){
        try{
            final int PORT = 8000;
            DatagramSocket ds = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("10.2.8.162");
            String s;

            do{
                BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Your ID: ");
                s = keyIn.readLine();
                //若無輸入，則跳出迴圈，不傳送字串
                if(s.equals("")){
                    break;
                }
                DatagramPacket dp = new DatagramPacket(s.getBytes(), s.length(), addr, PORT);
                ds.send(dp);
            } while(true);
            ds.close();

        } catch (Exception e){
            System.out.print(e);
        }


    }
}
