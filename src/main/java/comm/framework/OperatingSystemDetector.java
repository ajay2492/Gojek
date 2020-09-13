package comm.framework;

public class OperatingSystemDetector {

    public static String operatingSystem(){
        return System.getProperty("os.name").toLowerCase();
    }
}
