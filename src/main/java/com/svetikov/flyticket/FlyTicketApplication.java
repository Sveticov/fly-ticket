package com.svetikov.flyticket;

import com.svetikov.flyticket.storage.DataTicket;
import com.svetikov.flyticket.storage.DataTicketInt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlyTicketApplication implements CommandLineRunner {
    @Bean
    public DataTicketInt createDataTicket(){
        return new DataTicket();
    }

    public static void main(String[] args) {
        SpringApplication.run(FlyTicketApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        createDataTicket().addTicket();
        createDataTicket().printList();
        System.out.println( createDataTicket().listTicket().get(1));
    }
}


