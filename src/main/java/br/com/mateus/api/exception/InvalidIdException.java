package br.com.mateus.api.exception;

public class InvalidIdException extends RuntimeException{

    public InvalidIdException(){
		super();
	}

    public InvalidIdException(String s){
        super(s);
    }
}
