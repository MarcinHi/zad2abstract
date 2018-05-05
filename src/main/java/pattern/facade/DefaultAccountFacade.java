package pattern.facade;

public class DefaultAccountFacade implements AccountFacade {

    private final PaymentService paymentService;
    private final UserService userService;

    public DefaultAccountFacade(PaymentService paymentService, UserService userService) {
        this.paymentService = paymentService;
        this.userService = userService;
    }

    @Override
    public void pay(double value) {
        paymentService.pay(value);
    }

    @Override
    public String getAccountName() {
        return userService.getAccount().name;
    }
}
