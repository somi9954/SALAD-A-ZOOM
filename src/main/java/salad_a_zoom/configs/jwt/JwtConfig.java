package salad_a_zoom.configs.jwt;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(salad_a_zoom.configs.jwt.JwtProperties.class)
public class JwtConfig {
    @Bean
    public salad_a_zoom.configs.jwt.TokenProvider tokenProvider(salad_a_zoom.configs.jwt.JwtProperties jwtProperties) {
        return new salad_a_zoom.configs.jwt.TokenProvider(jwtProperties.getSecret(), jwtProperties.getAccessTokenValidityInSeconds());
    }
}