package pl.training.cloud.organization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import static pl.training.cloud.common.controller.Controller.ALL_URIS;
import static pl.training.cloud.common.controller.Controller.GLOBAL_PUBLIC_URIS;

@EnableResourceServer
@Configuration
public class ResourceServer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(GLOBAL_PUBLIC_URIS).permitAll()
                .antMatchers(ALL_URIS).hasRole(Role.ADMIN);
    }

}
