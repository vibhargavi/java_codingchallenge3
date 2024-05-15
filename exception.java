package exceptionss;
//patient number not found exception

public class exception extends Exception {
    public exception(String message) {
        super(message);
        
    }
    void showMsg() {
    	System.out.println("The given patient number is not found");
    }
}
