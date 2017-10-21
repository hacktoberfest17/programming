public class robot {

    private static final Object motitor = new Object();

    class Foot implements Runnable {
        private final String name;

        Foot(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (motitor) {
                    step();
                    motitor.notify();
                    try {
                        motitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void step() {
            System.out.println(name);
        }
    }

    public void run() {
        Foot left = new Foot("left");
        Foot right = new Foot("right");

        new Thread(left).start();
        new Thread(right).start();
    }

    public static void main(String[] args) {
        new robot().run();
    }

}
