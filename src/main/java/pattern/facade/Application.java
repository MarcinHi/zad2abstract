package pattern.facade;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserService();
        PaymentService paymentService = new PaymentService();
        AccountFacade facade= new DefaultAccountFacade(paymentService, userService);

        processAccount(facade);
    }

    private static void processAccount(AccountFacade facade) {
        String accountName = facade.getAccountName();
        System.out.println("Account "+ accountName + " is paying for sth");
        facade.pay(100);
    }
}
