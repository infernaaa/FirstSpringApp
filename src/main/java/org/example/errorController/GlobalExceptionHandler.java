package org.example.errorController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFoundError(NoHandlerFoundException ex, Model model) {
        model.addAttribute("error", "Page not found");
        return "error"; // Возвращаем шаблон error.html
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericError(Exception ex, Model model) {
        model.addAttribute("error", "An unexpected error occurred");
        return "error";
    }
}
