package org.ajou.realcoding.positioncrawler.positioncrawler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConfig {

    @Bean //어느클래스에서든 이 레스트템플릿을 필드로 선언해놓고 autowired를 쓰기만하면 이걸 맘대로 쓸수있음.
    public RestTemplate createRestTemplate()
    {
        return new RestTemplate(); //resttemplate: restful에맞춘 url형식 지원.
    }
}
