package com.springConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com"})
@EnableTransactionManagement
public class JavaConfig {
}
