package com.senla.springConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Component
@ComponentScan({"com"})
@EnableTransactionManagement
public class JavaConfig {


}
