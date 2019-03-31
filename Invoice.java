import java.util.ArrayList;
import java.util.Random;

public class Invoice {
    Random r = new Random();
    int n = r.nextInt(10)+1; //number of different items ordered
    ArrayList items = new ArrayList<String>();  //a unique code characterizes each item
    ArrayList q = new ArrayList<Integer>();    //ordered quantity of each item
    ArrayList price = new ArrayList<Double>();
    double finalPrice;
    double paymentsReceived;
    double paymentsDue;  //price - paymentsReceived;
    String billingAddress;
    String shippingAddress;
    String CustomerName;
   
}
