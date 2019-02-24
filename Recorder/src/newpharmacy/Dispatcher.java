
package newpharmacy;


public class Dispatcher {
    private MainWindow mainwindow;
    private Login login;
    
    public Dispatcher(){
        mainwindow = new MainWindow();
    }
    
    public void dispatch(){
        try{
            mainwindow.setVisible(true);
            login.dispose();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}
