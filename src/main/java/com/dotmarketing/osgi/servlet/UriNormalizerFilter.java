package com.dotmarketing.osgi.servlet;

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
import io.vavr.Function0;

public class UriNormalizerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
                    final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper((HttpServletRequest) servletRequest) {

            private Function0<String> normalizeUri =
                            Function0.of(() -> URI.create(super.getRequestURI()).normalize().toString()).memoized();


            @Override
            public String getRequestURI() {
                return normalizeUri.apply();
            }
        };
        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {}
}
