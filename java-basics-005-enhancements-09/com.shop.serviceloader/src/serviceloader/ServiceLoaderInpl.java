package serviceloader;

import services.ServiceLoaderIntf;

public class ServiceLoaderInpl implements ServiceLoaderIntf {
    @Override
    public String greet(String name) {
        return "Hello " + name + "!!!";
    }
}
