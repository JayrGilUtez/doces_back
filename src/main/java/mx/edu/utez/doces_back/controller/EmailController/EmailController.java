package mx.edu.utez.doces_back.controller.EmailController;

import jakarta.mail.MessagingException;
import jakarta.servlet.annotation.MultipartConfig;
import lombok.AllArgsConstructor;
import mx.edu.utez.doces_back.config.ApiResponse;
import mx.edu.utez.doces_back.service.email.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/email")
@CrossOrigin(origins = { "*" })
@AllArgsConstructor
@MultipartConfig

public class EmailController {

    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<ApiResponse> senderEmail(@RequestParam("toEmail") String email,
            @RequestParam("subject") String subject,
            @RequestParam("title") String title,
            @RequestParam("messageContent") String messageContent,
            @RequestParam("type") int type,
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name) throws MessagingException {
        return emailService
                .sendEmail(email, subject, title, messageContent, type, file, name);
    }
}