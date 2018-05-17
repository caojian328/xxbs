package com.zkai.financial;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*@EnableSidecar*/
@EnableZuulProxy
/*@EnableOAuth2Sso
@EnableAuthorizationServer*/
@SpringCloudApplication
public class GatewayApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(GatewayApplication.class).web(true).run(args);
	}

	/*@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		
		RestTemplate rest = new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(10000);
        requestFactory.setConnectTimeout(6000);
        rest.setRequestFactory(requestFactory);
        
		return rest;
	}*/
	
}
