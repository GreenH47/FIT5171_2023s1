package fit5171.monash.edu;

public class SeatLimitExceededException extends Exception{
    public SeatLimitExceededException(String message) {
        super(message);
    }
}
