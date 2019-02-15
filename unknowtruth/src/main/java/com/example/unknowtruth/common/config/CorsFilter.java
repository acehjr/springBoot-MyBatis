package com.example.unknowtruth.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@Slf4j
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
    		HttpServletResponse res = (HttpServletResponse) resp;

    		// 这里最好不要写通配符，如果允许多个域请求数据的话，可以直接用逗号隔开："http://www.baidu.com,http://google.com"  
    		  
    		res.setHeader("Access-Control-Allow-Origin", "*");  
    		  
    		res.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
    		  
    		res.setHeader("Access-Control-Allow-Headers", "Authorization,DNT,User-Agent,Keep-Alive,Content-Type,accept,origin,X-Requested-With");
    		  
    		res.setHeader("Access-Control-Allow-Credentials","true");

			res.addHeader("Access-Control-Max-Age","18000");

			res.addHeader("Access-Control-Expose-Headers","Content-Type,Access-Control-Allow-Origin,Access-Control-Allow-Headers,Access-Control-Request-Method,X-Requested-With,accept,Origin,Authorization");
    		  
    		chain.doFilter(req, resp);  
    		  
    		}
	@Override
    public void init(FilterConfig filterConfig) {}
	@Override
    public void destroy() {}
}