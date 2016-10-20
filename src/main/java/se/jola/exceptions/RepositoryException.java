package se.jola.exceptions;

public class RepositoryException extends Exception {

    private static final long serialVersionUID = -3525482399320031378L;


    public RepositoryException(String message){
	super(message);
    }
    

    public RepositoryException(String message, Exception e){
	super(message, e);
    }

}
