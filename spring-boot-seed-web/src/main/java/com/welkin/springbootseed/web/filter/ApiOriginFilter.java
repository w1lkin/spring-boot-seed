package com.welkin.springbootseed.web.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Provider
public class ApiOriginFilter implements ContainerResponseFilter {

    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        MultivaluedMap headers = responseContext.getHeaders();
        String origin = requestContext.getHeaderString("Origin");
        String host;
        if(origin != null) {
            try {
                URL referer = new URL(origin);
                host = referer.getProtocol() + "://" + referer.getHost();
                if(referer.getPort() != -1) {
                    host = host + ":" + referer.getPort();
                }
            } catch (MalformedURLException var9) {
                host = "*";
            }
        } else {
            String referer1 = requestContext.getHeaderString("Referer");

            try {
                URL e = new URL(referer1);
                host = e.getProtocol() + "://" + e.getHost();
                if(e.getPort() != -1) {
                    host = host + ":" + e.getPort();
                }
            } catch (MalformedURLException var8) {
                host = "*";
            }
        }

        headers.add("Access-Control-Allow-Origin", host);
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        headers.add("Access-Control-Allow-Headers", "Accept,Accept-Charset,Accept-Encoding,Accept-Language,Accept-Ranges,Authorization,Cache-Control,Connection,Cookie,Content-Length,Content-Type,Date,Expect,From,Host,If-Match,If-Modified-Since,If-None-Match,If-Range,If-Unmodified-Since,Max-Forwards,Pragma,Proxy-Authorization,Range,Referer,TE,Upgrade,User-Agent,Via,Warning,Signature,H5-Date,K-CrossDomain");
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Max-Age", "1209600");
    }
}
