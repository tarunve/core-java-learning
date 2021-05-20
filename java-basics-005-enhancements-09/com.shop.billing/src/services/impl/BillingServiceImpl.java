package services.impl;

import model.Invoice;
import services.BillingService;

import java.util.ArrayList;
import java.util.List;

public class BillingServiceImpl implements BillingService {
    @Override
    public List<Invoice> generate() {
        Invoice invoice = new Invoice();
        invoice.setCode("INV001");

        return List.of(invoice);
    }
}
