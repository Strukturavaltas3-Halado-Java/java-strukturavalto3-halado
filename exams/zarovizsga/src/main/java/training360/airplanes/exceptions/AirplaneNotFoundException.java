package training360.airplanes.exceptions;

public class AirplaneNotFoundException extends RuntimeException {

    public AirplaneNotFoundException(long id) {
        super("Airplane not found with id:" + id);
    }
}
