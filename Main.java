
import java.text.DecimalFormat;
import java.util.Random;

public class Main {

    public static void main(String args[]) {
        DecimalFormat df = new DecimalFormat("#.##");
        Random r = new Random();
        Invoice orders[] = new Invoice[50];

        for (int i = 0; i < 50; i++) {      //example for 50 orders
            orders[i] = new Invoice();
        }

        
        for (int i = 0; i < 50; i++) {
            orders[i].n = r.nextInt(10) + 1;  //amount of different products ordered
            orders[i].billingAddress = randomStringGen();
            orders[i].shippingAddress = randomStringGen();
            orders[i].CustomerName = randomNameGen();
            for (int j = 0; j < orders[i].n; j++) {
                orders[i].items.add(randomStringGen()); //product code
                orders[i].price.add(randomPriceGen()); //price per product
                orders[i].q.add(r.nextInt(10) + 1); //max quantity to order of one product is 10 
                orders[i].finalPrice += (int) (orders[i].q.get(j)) * (double) (orders[i].price.get(j));
            }
            orders[i].paymentsReceived = randomPaymentsReceivedGen(orders[i].finalPrice);   //payment received for an order
        }
        
        
        //calculate payment due for each order
        for (int i = 0; i < 50; i++) {
            orders[i].paymentsDue = orders[i].finalPrice - orders[i].paymentsReceived;
        }
        
        //Print receipts/invoices
        for (int i = 0; i < 50; i++) {
            System.out.println("\nCustomer " + orders[i].CustomerName + " ordered: " + orders[i].n + " different products: " + orders[i].items + "\n");
            int j = 0;
            while (j < orders[i].n) {
                System.out.println("Quantity: " + orders[i].q.get(j) + " of product: " + orders[i].items.get(j));
                j++;
            }
            System.out.println("\nWith Shipping Address: " + orders[i].shippingAddress + " and billing address: " + orders[i].billingAddress + "\n");
            System.out.println("Total Amount: " + df.format(orders[i].finalPrice) + "\nPaid Amount: " + df.format(orders[i].paymentsReceived) + "\nPayment Due: " + df.format(orders[i].paymentsDue));
            System.out.println("\n--------------------------------------------------------------------------\n");
        }
    }

    public static String randomStringGen() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();

        return output;
    }

    public static String randomNameGen() {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();

        return output;
    }

    public static double randomPriceGen() {
        Random r = new Random();
        double x = 1 + r.nextDouble() * (1000); //price range
        return x;
    }

    public static double randomPaymentsReceivedGen(double price) {
        Random r = new Random();
        double x = 1 + r.nextDouble() * (price); //max to have been paid
        return x;
    }

}
