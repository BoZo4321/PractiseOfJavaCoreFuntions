package javCore2;

public class BeatlesException extends Exception{

    public BeatlesException(Throwable uzrok){
        super(uzrok.getMessage() + " Beatles ", uzrok);
    }

}
