package coderHouse.JPA.services;

import coderHouse.JPA.entities.Invoice;
import coderHouse.JPA.entities.InvoiceDetail;
import coderHouse.JPA.reposotories.InvoiceRepository;
import coderHouse.JPA.reposotories.InvoiceDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    // Guardar una factura con detalles
    public Invoice saveInvoice(Invoice invoice) {
        invoice.getDetails().forEach(detail -> detail.setInvoice(invoice));
        return invoiceRepository.save(invoice);
    }

    // Obtener todas las facturas
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // Obtener una factura por ID
    public Optional<Invoice> getInvoiceById(int id) {
        return invoiceRepository.findById(id);
    }

    // Actualizar el total de la factura
    public Optional<Invoice> updateInvoiceTotal(int id, double total) {
        return invoiceRepository.findById(id).map(invoice -> {
            invoice.setTotal(total);
            return invoiceRepository.save(invoice);
        });
    }

    // Agregar un detalle a una factura existente
    public Optional<InvoiceDetail> addInvoiceDetail(int invoiceId, InvoiceDetail detail) {
        return invoiceRepository.findById(invoiceId).map(invoice -> {
            detail.setInvoice(invoice);
            return invoiceDetailRepository.save(detail);
        });
    }

    // Obtener detalles de una factura específica
    public List<InvoiceDetail> getDetailsByInvoiceId(int invoiceId) {
        return invoiceDetailRepository.findByInvoiceId(invoiceId);
    }

    // Eliminar una factura y sus detalles
    public boolean deleteInvoice(int id) {
        if (invoiceRepository.existsById(id)) {
            invoiceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

