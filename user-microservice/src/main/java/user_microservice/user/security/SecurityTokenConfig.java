package user_microservice.user.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {

    private JwtConfig jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS )
                .and()
                    .exceptionHandling().authenticationEntryPoint( ((httpServletRequest, httpServletResponse, e) -> httpServletResponse.sendError( HttpServletResponse.SC_UNAUTHORIZED )) )
                .and()
                    .addFilterAfter( new JwtTokenAuthenticationFilter( jwtConfig ), UsernamePasswordAuthenticationFilter.class )
                .authorizeRequests()
                    .antMatchers( HttpMethod.POST, jwtConfig.getUri());
    }

    public JwtConfig jwtConfig() {return new JwtConfig();}
}
