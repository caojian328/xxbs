package com.zkai.financial.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/*@Component*/
public class IPFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(IPFilter.class);

	private static List<String> iptables = new ArrayList<String>();

	static {
		iptables.add("127.0.0.1");
		iptables.add("localhost");
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String ip = this.getRemoteHost(request);
		log.info("{} {} request", ip, request.getMethod());

		
		if (iptables.contains(ip)) {
			log.info("{} is in iptabls", ip);
		} else {
			log.error("{} is not in iptabls", ip);
			ctx.setResponseBody("ip is not in iptabls");
			ctx.setResponseStatusCode(401);
			return null;
		}

		return null;
	}
	
	
	private String getRemoteHost(javax.servlet.http.HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

}
