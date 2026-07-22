import java.util.concurrent.CountDownLatch;

class Foo {

    private CountDownLatch firstDone;
    private CountDownLatch secondDone;

    public Foo() {
        firstDone = new CountDownLatch(1);
        secondDone = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstDone.countDown();   // Signal first is complete
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.await();       // Wait for first
        printSecond.run();
        secondDone.countDown();  // Signal second is complete
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondDone.await();      // Wait for second
        printThird.run();
    }
}
