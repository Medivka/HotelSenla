import com.springConfig.SpringBeans;


public class MainProgramm {

    public static void main(String[] args) {
        SpringBeans.init();
        System.out.println(SpringBeans.fasadService.findById(1));
}}
