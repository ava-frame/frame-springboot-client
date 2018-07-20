package com.ava.frame.springboot.client.conf;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

@Component
public class MyEmbeddedServletContainerFactory extends TomcatEmbeddedServletContainerFactory
{
    @Value("${tomcat.port:8080}")
    private int port;
    @Value("${tomcat.max.connection:1000}")
    private int maxConnection;
    @Value("${tomcat.max.thread:2000}")
    private int maxThread;
    @Value("${tomcat.timeout:2000}")
    private int timeout;
    public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers)
    {
        //设置端口Integer.parseInt(MessageSource.message("server.port","8080"))
        this.setPort(port);
        return super.getEmbeddedServletContainer(initializers);
    }

    @Override
    protected void customizeConnector(Connector connector)
    {
        super.customizeConnector(connector);
        Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
        //设置最大连接数
        protocol.setMaxConnections(maxConnection);
        //设置最大线程数
        protocol.setMaxThreads(maxThread);
        //连接超时数
        protocol.setConnectionTimeout(timeout);
    }
}
