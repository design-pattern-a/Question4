
package newpharmacy;


public class FrontController {
    private Dispatcher dispatcher;
    
    public FrontController(){
        dispatcher = new Dispatcher();
    }
    
    private boolean isAuth(){
        return true;
    }
    
    public void dispatchRequest(){
        if(isAuth()){
            dispatcher.dispatch();
        }
    }
    
}
