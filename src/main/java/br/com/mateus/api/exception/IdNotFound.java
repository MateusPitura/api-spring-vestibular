package br.com.mateus.api.exception;

public class IdNotFound extends RuntimeException{
    
    public IdNotFound(){
		super();
	}

    public IdNotFound(String s){
        super(s);
    }
}
