import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Runnable r2 = () -> {
            Random random = new Random();
            int ranNum = random.nextInt(10000000);
            while (ranNum != 123) {
                ranNum = random.nextInt(10000000);
            }
            System.out.println("Found it!");
        };
        FuncStufferExtra funcStufferExtra = Runnable::run;
        funcStufferExtra.doStuffDefault(r2, true, true, true);

 //       Reducer<Integer, String> p = Object::toString;

//        p.before(() -> _).after(() -> _).before(() -> _).emit();

        System.out.println("_______________________________________");

        FuncStuffer funcStufferDecorator = () -> System.out.println("Inside lambda");

        new HelloWorldDecorator(
                new MeasurerFuncTimeDecorator(
                        new PostCompleteDecorator(
                                () -> System.out.println("Inside lambda")
                        )
                )
        ).doStuffFunc();

    }
}