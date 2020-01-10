package com.dotcms.osgi.filter;

import java.io.IOException;
import java.net.URI;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UriNormalizerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
                    final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper((HttpServletRequest) servletRequest) {


            @Override
            public String getRequestURI() {
                return URI.create(super.getRequestURI()).normalize().toString();
            }
        };
        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {}
}
