package com.zzm.config;


import com.zzm.controller.MyWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myMessageHandler(), "/websocket");
    }

    @Bean
    public WebSocketHandler myMessageHandler() {
        return new MyWebSocketHandler();
    }
}
//@Configuration
//public class WebSocketConfig {
//
////    @Bean
////    public ServerEndpointExporter serverEndpointExporter() {
////        return new ServerEndpointExporter();
////    }
////
////    @Bean
////    public ServerEndpointRegistration myWebSocket() {
////        return new ServerEndpointRegistration("/websocket", new MyWebSocketHandler());
////    }
//@Bean
//public MyWebSocketHandler myWebSocket() {
//    return new MyWebSocketHandler();
//}
//
//}


