package com.revature.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CorsFilter implements Filter {
	/*
	 * The idea of a Filter, is that before the request is delegated to a Servlet,
	 * it must first pass through any and all filters
	 * These filters can manipulate the request/response as needed
	 * 
	 * In this particular case, we will be adding certain headers required to allow Cross
	 * Origin requests (remember, our fetch request in JS didn't work prior to adding this...)
	 * 
	 * However, we can have filters to detect certain requests, and perhaps deny them
	 * before they even reach a Servlet
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CORS Filter leveraged");
		if(!(response instanceof HttpServletResponse)) {
			chain.doFilter(request, response);
			return;
		}
//		String requestUrl = request.getRemoteHost() + ":" + request.getRemotePort();
		

  
        HttpServletRequest req = (HttpServletRequest) request;
		System.out.println(setAllowedOrigin(req));
		
		// Cast the response as an HttpServletResponse
		// Which is important, because we are going to set
		// headers, which is specific to HTTP
		HttpServletResponse res = (HttpServletResponse) response; //setAllowedOrigin(req)
		res.setHeader("Access-Control-Allow-Origin", setAllowedOrigin(req)); // Allow all origins
		res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		// Allow specific HTTP Verbs
		res.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type,"
				+ "Access-Control-Request-Method, Access-Control-Request-Headers, "
				+ " Connection, Sec-Fetch-Site,User-Agent, Sec-Fetch-Mode, Sec-Fetch-Dest");
		// Allow specific HTTP Headers (there's a fair few)
		res.setHeader("Access-Control-Allow-Credentials", "true");
		// Credentials are allowed
		chain.doFilter(request, response);
		// Continue the filter chain
		System.out.println("filter is done");
	}
	
	private String setAllowedOrigin(HttpServletRequest request) {
		//String origins = request.getRequestURI();
		String origins ="http://127.0.0.1:5500, https://127.0.0.1:5000";
        String requestOrigin = request.getHeader("origin");
        //log.info("Request is received with origin header : {}", requestOrigin);
        List<String> originsList = Arrays.stream(origins.split(","))
                .map(String::trim).filter(origin -> !origin.equals("")).collect(Collectors.toList());
        //log.info("origins List : {}", originsList);
        if (!originsList.isEmpty() && requestOrigin != null) {
            Optional<String> origin = originsList.stream().filter(allowedOrigin -> allowedOrigin.equals(requestOrigin)).findFirst();
            return origin.orElseGet(() -> originsList.get(0));
        }
        return "*";
    }
}