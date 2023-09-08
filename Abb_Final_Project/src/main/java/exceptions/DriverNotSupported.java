package exceptions;

public class DriverNotSupported extends Exception{
    public DriverNotSupported(String browser) {
        super(String.format("Browser %s not supported", browser));
    }

}
