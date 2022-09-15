package exceptions;


public class OrderAlreadyAddedException extends Exception {
    public OrderAlreadyAddedException() {
        super("Заказ уже связан со столиком или адресом");
    }
}
