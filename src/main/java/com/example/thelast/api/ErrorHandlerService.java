package com.example.thelast.api;



import com.example.thelast.exception.ApplicationError;
import com.example.thelast.exception.CustomerNotFound;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class ErrorHandlerService {
    @Value("${api_doc_url}")
    private String Detail;
    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<ApplicationError> handleCustomerNotFound(CustomerNotFound exception, WebRequest webRequest){

        ApplicationError error = new ApplicationError();
        error.setCode(101);
        error.setMessage(exception.getMessage());
        error.setDetail(Detail);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
