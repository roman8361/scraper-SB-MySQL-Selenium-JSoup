package ru.pirateway.sb.api.service;

import ru.pirateway.sb.exception.DataValidateException;

import java.io.IOException;

/**
 * @author Roman Kravchenko
 */

public interface IBootstrapService {

    void init() throws InterruptedException, DataValidateException, IOException;

}
