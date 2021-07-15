package by.prohor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Artsiom Prokharau 15.07.2021
 */

@SpringBootApplication
@ImportResource({"classpath:add_value/listEvent.xml", "classpath:add_value/listUser.xml", "classpath:add_value/mapTicket.xml"})
@PropertySource({"classpath:add_value/prop/user.properties", "classpath:add_value/prop/event.properties", "classpath:add_value/prop/ticket.properties"})
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}
