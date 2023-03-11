public class MeasurerFuncTimeDecorator implements FuncStuffer{

    private final FuncStuffer stuffer;

    public MeasurerFuncTimeDecorator(FuncStuffer stuffer) {
        this.stuffer = stuffer;
    }

    @Override
    public void doStuffFunc() {
        long time = System.currentTimeMillis();
        stuffer.doStuffFunc();
        time = System.currentTimeMillis() - time;
        System.out.println("Program time: " + time + "ms");
    }
}
