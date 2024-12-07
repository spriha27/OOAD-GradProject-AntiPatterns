package java.code.cargocultprogramming;

public class NetworkConfigExample {
    public static void main(String[] args) {
        NetworkConfig config = new NetworkConfig(5000, 2);
        System.out.println("Timeout: " + config.getTimeout());
        System.out.println("Retries: " + config.getRetries());
    }
}

class NetworkConfig {
    private int timeout;
    private int retries;

    public NetworkConfig(int timeout, int retries) {
        this.timeout = timeout;
        this.retries = retries;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getRetries() {
        return retries;
    }
}
