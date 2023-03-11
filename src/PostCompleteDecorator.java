public class PostCompleteDecorator implements FuncStuffer{

    private final FuncStuffer stuffer;

    public PostCompleteDecorator(FuncStuffer stuffer) {
        this.stuffer = stuffer;
    }

    @Override
    public void doStuffFunc() {
        stuffer.doStuffFunc();
        try {
            Thread.sleep(123);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
