package coderHouse.JPA.services;

import coderHouse.JPA.entities.InvoiceDetail;
import coderHouse.JPA.reposotories.InvoiceDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailService {

    private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailService(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    public InvoiceDetail saveInvoiceDetail(InvoiceDetail invoiceDetail) {
        return invoiceDetailRepository.save(invoiceDetail);
    }

    public List<InvoiceDetail> getAllInvoiceDetails() {
        return invoiceDetailRepository.findAll();
    }

    public Optional<InvoiceDetail> getInvoiceDetailById(int id) {
        return invoiceDetailRepository.findById(id);
    }

    public void deleteInvoiceDetail(int id) {
        invoiceDetailRepository.deleteById(id);
    }
}
