package com.springConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com", "GUI.src.main.java.mainMenuControllers"})
@EnableTransactionManagement
public class RootConfig {
}
