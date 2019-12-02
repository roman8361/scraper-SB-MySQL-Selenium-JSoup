package ru.pirateway.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.pirateway.sb.api.service.IBootstrapService;
import ru.pirateway.sb.exception.DataValidateException;

import java.io.IOException;

@SpringBootApplication
public class ParserApplication {

    public static void main(String[] args) throws InterruptedException, DataValidateException, IOException {
        IBootstrapService bootstrapService = SpringApplication.run(ParserApplication.class, args).getBean(IBootstrapService.class);
        bootstrapService.init();
    }

}
