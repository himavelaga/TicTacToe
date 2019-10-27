package tictac;

import junit.framework.*;
import tictac.HelloBean;

/*
 *Test class for the HelloBean, that simply returns a
 *'Hello Beanie" message. This version is written with
 * a main method, in case ANT junit does not work.
 */

public class HelloBeanTestMain extends TestCase{

/*
 *Run the tests as a main method
 */
public static void main (String[] args){
   testBean();
}
/*
 *Test that the bean produces the message "Hello Beanies"
 */
static public void testBean() {
   HelloBean testee = new HelloBean();
   System.out.println ("Running HelloBeanTestMain, bad test included");
//   assertEquals("Bean message ","Hello Beanies", testee.getMessage());
   assertEquals("Bean message ","Hi, I am from Mars", testee.getMessage());
     
}//testBean

}//HelloBeanTest
