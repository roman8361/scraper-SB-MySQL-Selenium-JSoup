package ru.pirateway.sb.api.service;


import ru.pirateway.sb.exception.DataValidateException;

import java.io.IOException;

public interface IBetScraperService {

    void separateHtml(String pageHtml) throws DataValidateException, IOException, InterruptedException;

}
