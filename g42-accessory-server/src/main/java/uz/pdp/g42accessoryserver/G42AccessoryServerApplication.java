package uz.pdp.g42accessoryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.pdp.g42accessoryserver.config.InitConfig;

@SpringBootApplication
public class G42AccessoryServerApplication {

    public static void main(String[] args) {
        if (InitConfig.isStart()){
            SpringApplication.run(G42AccessoryServerApplication.class, args);
        }
    }

}
