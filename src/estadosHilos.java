// Java program to demonstrate thread states
class thread implements Runnable {
    public void run()
    {
        // moving thread2 to timed waiting state
        try {
            Thread.sleep(1500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
            "Estado de thread1 mientras llama join() metodo en el thread2 -"
            + estadosHilos.thread1.getState());
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class estadosHilos implements Runnable {
    public static Thread thread1;
    public static estadosHilos obj;

    public static void main(String[] args)
    {
        obj = new estadosHilos();
        thread1 = new Thread(obj);

        // thread1 creado y en estado Nuevo
        System.out.println(
            "Estado de thread1 despues de ser creado - "
            + thread1.getState());
        thread1.start();

        // thread1 a estado ejecutable
        System.out.println(
            "Estado de thread1 despues de llamar .start() metodo en este - "
            + thread1.getState());
    }

    public void run()
    {
        thread myThread = new thread();
        Thread thread2 = new Thread(myThread);

        // thread2 created y en estado nuevo
        System.out.println(
            "Estado de thread2 despues de ser creado - "
            + thread2.getState());
        thread2.start();

        // thread2 cambiado a estado ejecutable
        System.out.println(
            "Estado de thread2 despues de llamar .start() metodo en este - "
            + thread2.getState());

        // moviendo thread1 a tiemo de espera
        try {
            // moviendo thread1 a estado espera
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
            "Estado de thread2 despues de llamar .sleep() metodo en este - "
            + thread2.getState());

        try {
            // esperando thread2 a que finalice
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
            "Estado de thread2 cuando finalizo su ejecucion - "
            + thread2.getState());
    }
}
