package by.kirienko.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoSuchCabinetException extends RuntimeException {

    public NoSuchCabinetException() {
    }

    public NoSuchCabinetException(String message) {
        super(message);
    }
}
