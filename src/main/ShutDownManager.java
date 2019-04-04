package main;

import java.io.IOException;

class ShutDownManager {
    static void shutDownSystem() {
        String property = System.getProperty("os.name");
        System.out.println(property);
        if (property.toLowerCase().contains("windows")) {
            String[] commands = {"shutdown", "-s"};
            try {
                Process process = Runtime.getRuntime().exec(commands);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}