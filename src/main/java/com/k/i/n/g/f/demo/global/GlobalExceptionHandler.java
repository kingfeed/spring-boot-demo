package com.k.i.n.g.f.demo.global;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dongfei
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e) {
        e.printStackTrace();
        if(e instanceof BindException) {
            List<ObjectError> objectErrorList = ((BindException) e).getBindingResult().getAllErrors();
            return objectErrorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.joining());
        }
        if(e instanceof ConstraintViolationException ){
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();
            Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
            if (iterator.hasNext()) {
                ConstraintViolation<?> next = iterator.next();
                return  next.getMessage();
            }
        }
        return e.getMessage();
    }

}
