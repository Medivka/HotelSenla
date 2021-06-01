package springConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Component
@ComponentScan({"com.senla"})
@EnableTransactionManagement
public class JavaConfig {


}
