package com.k.i.n.g.f.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dongfei
 */
@Slf4j
@Service
public class HelloWorldServiceImpl implements HellWorldService {

    @Override
    public void say(String words) {
        log.info("words = {}",words);
    }
}
