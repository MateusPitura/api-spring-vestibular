package br.com.mateus.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 

@RequestMapping("/url") 

public class Class { 

@GetMapping 

public String metodo(){ 

return "Hello, world!"; 

} 

} 