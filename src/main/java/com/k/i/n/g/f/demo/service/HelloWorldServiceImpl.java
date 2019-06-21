package com.k.i.n.g.f.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author dongfei
 */
@Slf4j
@Service
@Validated
public class HelloWorldServiceImpl implements HellWorldService {

    @Autowired
    private Validator validator;

    @Override
    public void say(String words) {
        log.info("words = {}",words);
    }

    @Override
    public void say(String who, String words) {
        log.info("the user {} ,says {}",who,words);
    }

    @Override
    public void say(Hello hello) {
        Set<ConstraintViolation<Hello>> constraintViolations = validator.validate(hello);
        log.info("how can it be");
    }
}
