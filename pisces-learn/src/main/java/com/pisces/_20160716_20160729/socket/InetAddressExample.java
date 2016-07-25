package com.pisces._20160716_20160729.socket;

import org.apache.commons.collections.CollectionUtils;

import java.net.*;
import java.util.Enumeration;

/**
 * Created by jun.xu on 16/7/19.
 */
public class InetAddressExample {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            System.out.println("there is no network interfaces");
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            if (inetAddresses == null) {
                System.out.println(networkInterface.getName() + ",there is no InetAddresses");
            }
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                System.out.println((inetAddress instanceof Inet4Address == true ? "ipv4-" : inetAddress instanceof Inet6Address == true ? "ipv6-" : "unknown:") + inetAddress.getHostName() + "," + inetAddress.getHostAddress());
            }
        }

        InetAddress[] inetAddresses= InetAddress.getAllByName("http://www.baidu.com");
        for(InetAddress inetaddress:inetAddresses){
            System.out.println(inetaddress.getHostName()+":"+inetaddress.getHostAddress());
        }

    }

}
