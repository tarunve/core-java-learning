package main;

import delivery.service.DeliveryService;
import model.Invoice;
import services.ServiceLoaderIntf;
import java.util.List;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
        deliveryService.deliver();

        List<Invoice> list = deliveryService.deliverInvoices();
        list.forEach(System.out::println);

        ServiceLoader<ServiceLoaderIntf> services = ServiceLoader.load(ServiceLoaderIntf.class);
        services.stream().forEach(i -> System.out.println(i.get().greet("Tarun")));
    }
}
