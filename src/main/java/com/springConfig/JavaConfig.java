package com.springConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Component
@ComponentScan({"com", "GUI.src.main.java.mainMenuControllers"})
@EnableTransactionManagement
public class JavaConfig {


}
