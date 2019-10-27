package tictac;

/**
 * Class to output a simple Hello message 
 */
public class HelloBean {

private String message;

/* No-argument constructor, setting the
 * message to 'Hello Beanies'
 */
public HelloBean(){
   message = "Hello Beanies";
   System.out.println("Initializing HelloBean");
}

/*
 * Return the message
 */
public String getMessage() {
   return message;
}

}//TestBean
