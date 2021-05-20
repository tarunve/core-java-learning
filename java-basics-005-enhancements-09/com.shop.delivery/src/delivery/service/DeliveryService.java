package delivery.service;

import model.Invoice;
import services.BillingService;
import java.util.List;

public class DeliveryService {

    public void deliver(){
        BillingService billingService = BillingService.build();
        List<Invoice> invoices = billingService.generate();
        invoices.forEach(System.out::println);
    }

    public List<Invoice> deliverInvoices(){
        BillingService billingService = BillingService.build();
        return billingService.generate();
    }
}
