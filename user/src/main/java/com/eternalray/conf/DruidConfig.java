package com.eternalray.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Eternalray
 * 数据库监控和生效配置文件配置
 */
@Configuration
public class DruidConfig {

    /**
     * DRUID_USERNAME Druid后台监控账号名
     */
    private final static String DRUID_USERNAME="admin";
    /**
     * DRUID_PASSWORD Druid后台监控密码
     */
    private final static String DRUID_PASSWORD="123456";

    @ConfigurationProperties(
            prefix = "spring.datasource"
    )
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), new String[]{"/druid/*"});
        Map<String, String> initParams = new HashMap<>(16);
        initParams.put("loginUsername", DRUID_USERNAME);
        initParams.put("loginPassword", DRUID_PASSWORD);
        initParams.put("allow", "");
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter(), new ServletRegistrationBean[0]);
        Map<String, String> initParams = new HashMap<>(16);
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
