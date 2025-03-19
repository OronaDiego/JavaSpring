package coderHouse.JPA.controllers;

import coderHouse.JPA.entities.Invoice;
import coderHouse.JPA.entities.InvoiceDetail;
import coderHouse.JPA.services.InvoiceService;
import coderHouse.JPA.services.InvoiceDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceDetailService invoiceDetailService;

    public InvoiceController(InvoiceService invoiceService, InvoiceDetailService invoiceDetailService) {
        this.invoiceService = invoiceService;
        this.invoiceDetailService = invoiceDetailService;
    }


    @PostMapping
    @Operation(summary = "Crear una nueva factura", description = "Guarda una nueva factura en la base de datos.")
    @ApiResponse(responseCode = "201", description = "Factura creada exitosamente")
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice savedInvoice = invoiceService.saveInvoice(invoice);
        return ResponseEntity.ok(savedInvoice);
    }


    @GetMapping
    @Operation(summary = "Obtener todas las facturas", description = "Retorna una lista con todas las facturas registradas.")
    @ApiResponse(responseCode = "200", description = "Lista de facturas obtenida exitosamente")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Obtener una factura por ID", description = "Retorna una factura específica según el ID proporcionado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Factura encontrada"),
            @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable int id) {
        return invoiceService.getInvoiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    @Operation(summary = "Actualizar el total de una factura", description = "Modifica el total de una factura específica.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Total actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<Invoice> updateInvoiceTotal(@PathVariable int id, @RequestBody double total) {
        return invoiceService.updateInvoiceTotal(id, total)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una factura", description = "Elimina una factura por ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Factura eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<Void> deleteInvoice(@PathVariable int id) {
        if (invoiceService.deleteInvoice(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🚀 Agregar un detalle a una factura existente
    @PostMapping("/{id}/details")
    public ResponseEntity<InvoiceDetail> addInvoiceDetail(@PathVariable int id, @RequestBody InvoiceDetail detail) {
        Optional<InvoiceDetail> savedDetail = invoiceService.addInvoiceDetail(id, detail);
        return savedDetail.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🚀 Obtener los detalles de una factura
    @GetMapping("/{id}/details")
    public ResponseEntity<List<InvoiceDetail>> getInvoiceDetails(@PathVariable int id) {
        List<InvoiceDetail> details = invoiceService.getDetailsByInvoiceId(id);
        return ResponseEntity.ok(details);
    }

    // 🚀 Eliminar un detalle específico de una factura
    @DeleteMapping("/details/{detailId}")
    public ResponseEntity<Void> deleteInvoiceDetail(@PathVariable int detailId) {
        invoiceDetailService.deleteInvoiceDetail(detailId);
        return ResponseEntity.noContent().build();
    }
}
