package com.zkai.financial.logs;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

/**
 *
 * 
 */
public class Log4jMailLayout extends PatternLayout {

	StringBuffer sbuf = new StringBuffer(BUF_SIZE);

	@Override
	public String getContentType() {
		return "text/html;charset=UTF-8"; // 处理乱码
	}

	@Override
	public String format(LoggingEvent event) {
		if (sbuf.capacity() > MAX_CAPACITY) {
			sbuf = new StringBuffer(BUF_SIZE);
		} else {
			sbuf.setLength(0);
		}
		sbuf.append("<pre>服务器IP地址 : " + getLocalIP() + "<BR/>");
		sbuf.append("错误时间: " + new SimpleDateFormat("yyyy-MM-dd HH:ss:mm").format(new Date()) + "<BR/>");
		sbuf.append("错误等级 : " + event.getLevel().toString() + "<BR/>");
		sbuf.append("错误所在类 : " + event.getLocationInformation().getClassName()
				+ "<BR/>");
		sbuf.append("错误方法所在 : "
				+ event.getLocationInformation().getMethodName() + "<BR/>");
		sbuf.append("错误行 : " + event.getLocationInformation().getLineNumber()
				+ "<BR/>");
		sbuf.append("错误原因 : <pre>" + super.format(event) + "<pre><BR/></pre>");

		return sbuf.toString();
	}

	/**
	 * 获取本机IP
	 * 
	 * @return
	 */
	private static String getLocalIP() {

		String ip = "";
		
		try {
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface
					.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements()) {
				NetworkInterface ni = networkInterfaces.nextElement();
				if (ni.getName().equals("eth0")) {
					Enumeration<InetAddress> inetAddresses = ni
							.getInetAddresses();
					while (inetAddresses.hasMoreElements()) {
						InetAddress ia = inetAddresses.nextElement();
						if (ia instanceof Inet6Address) {
							continue;
						}
						ip = ia.getHostAddress();
					}
					break;
				}
			}
		} catch (SocketException e) {
			ip = e.getMessage();
		}

		return ip;
	}

}
