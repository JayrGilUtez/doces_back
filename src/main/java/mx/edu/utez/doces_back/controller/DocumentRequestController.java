package mx.edu.utez.doces_back.controller;


import mx.edu.utez.doces_back.config.ApiResponse;
import mx.edu.utez.doces_back.model.DocumentRequest;
import mx.edu.utez.doces_back.service.DocumentRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/documentRequest")
public class DocumentRequestController {
    private final DocumentRequestService documentRequestService;

    public DocumentRequestController(DocumentRequestService documentRequestService) {
        this.documentRequestService = documentRequestService;
    }

    @PostMapping("/{userId}/{documentName}")
    public ResponseEntity<ApiResponse> createDocumentRequest(@PathVariable Integer userId, @PathVariable String documentName) {
        return documentRequestService.createDocumentRequest(userId, documentName);
    }

    @PutMapping("status/{documentRequestId}/{status}")
    public ResponseEntity<ApiResponse> updateStatus(@PathVariable Integer documentRequestId, @PathVariable String status) {
        return documentRequestService.updateStatus(documentRequestId, status);

    }

    @PutMapping("priority/{documentRequestId}/{priority}")
    public ResponseEntity<ApiResponse> updatePriority(@PathVariable Integer documentRequestId, @PathVariable String priority) {
        return documentRequestService.updatePriority(documentRequestId, priority);

    }

    @DeleteMapping("/{documentRequestId}")
    public ResponseEntity<ApiResponse> deleteDocumentRequest(@PathVariable Integer documentRequestId) {
        return documentRequestService.deleteDocumentRequest(documentRequestId);
    }


}
