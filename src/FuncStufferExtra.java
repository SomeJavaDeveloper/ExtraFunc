
@FunctionalInterface
public interface FuncStufferExtra {

    default void doStuffDefault(Runnable runnable, boolean isLogged, boolean isTimeMeasured, boolean isCalledTwice) {
        boolean isFuncCallInvoked = false;
        Runnable runnableComp = runnable;
        if (isLogged) {
            runnableComp = () -> {
                System.out.println("Start of the program");
                doStuffFunc(runnable);
            };
            isFuncCallInvoked = true;
        }

        if (isCalledTwice) {
            Runnable finalRunnableComp = runnableComp;
            if (isFuncCallInvoked) {
                runnableComp = () -> {
                    finalRunnableComp.run();
                    doStuffFunc(runnable);
                };
            } else {
                runnableComp = () -> {
                    doStuffFunc(runnable);
                    doStuffFunc(runnable);
                };
                isFuncCallInvoked = true;
            }
        }
        if (isTimeMeasured) {
            Runnable finalRunnableComp = runnableComp;

            if (isFuncCallInvoked) {
                runnableComp = () -> {
                    long time = System.currentTimeMillis();
                    finalRunnableComp.run();
                    time = System.currentTimeMillis() - time;
                    System.out.println("Program time: " + time + "ms");
                };
            } else {
                runnableComp = () -> {
                    long time = System.currentTimeMillis();
                    doStuffFunc(runnable);
                    time = System.currentTimeMillis() - time;
                    System.out.println("Program time: " + time + "ms");
                };
            }
        }
        runnableComp.run();
    }

    void doStuffFunc(Runnable runnable);
}
