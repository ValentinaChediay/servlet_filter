package com.example.servlet_filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Log2Filter implements Filter {

    private String logFile;

    public Log2Filter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.logFile = fConfig.getInitParameter("logFile");

        System.out.println("Log File " + logFile);
    }

    @Override
    public void destroy() {
        System.out.println("Log2Filter destroy!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (this.logFile != null) {
            // Записать информацию Log в File.
            this.logToFile(this.logFile);
        }

        // Разрешить данный request пройти дальше. (Пройти этот Filter).
        chain.doFilter(request, response);
    }

    private void logToFile(String fileName) {
        // Записать log в file..
        System.out.println("Write log to file " + fileName);
    }

}
