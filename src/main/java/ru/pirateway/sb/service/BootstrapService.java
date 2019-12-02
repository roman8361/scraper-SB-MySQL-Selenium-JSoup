package ru.pirateway.sb.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pirateway.sb.api.repository.IForkRepository;
import ru.pirateway.sb.api.service.IBetScraperService;
import ru.pirateway.sb.api.service.IBootstrapService;
import ru.pirateway.sb.api.service.IConnectService;
import ru.pirateway.sb.exception.DataValidateException;

import java.io.IOException;

/**
 * @author Roman Kravchenko
 */

@Component
public class BootstrapService implements IBootstrapService {

    @Autowired
    IConnectService connectService;

    @Autowired
    IBetScraperService betScraperService;

    @Autowired
    IForkRepository forkRepository;

    @Override
    public void init() throws InterruptedException, DataValidateException, IOException {
        connectService.getConnect();
        WebDriver webDriver = connectService.getDriver();

        while (true){
            betScraperService.separateHtml(connectService.getHtml(webDriver));
            Thread.sleep(5000);
            forkRepository.deleteAll();
            connectService.refreshPage(webDriver);
        }
    }

}
