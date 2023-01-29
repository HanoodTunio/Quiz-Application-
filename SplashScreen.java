package finalproject;
public class SplashScreen {
    public static void main(String[]args){
        NewJFrame frame=new NewJFrame();
         StatusWindow status;
        frame.setVisible(true);
        
        try{
            for(int i=0; 100>=i; i++ ){
                Thread.sleep(70);
                frame.jLabel2.setText(Integer.toString(i)+"%");
                frame.jProgressBar3.setValue(i);
              if(i==100){
                  frame.setVisible(false);
                  status =new StatusWindow();                
              }    
            }             
        }
        catch(Exception e){
            
        }
    }
    
}
