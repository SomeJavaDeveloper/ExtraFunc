public class HelloWorldDecorator implements FuncStuffer{

    private final FuncStuffer stuffer;

    public HelloWorldDecorator(FuncStuffer stuffer) {
        this.stuffer = stuffer;
    }

    @Override
    public void doStuffFunc() {
        stuffer.doStuffFunc();
        System.out.println("Final Decorator!");
    }
}
