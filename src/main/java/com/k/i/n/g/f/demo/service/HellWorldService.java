package com.k.i.n.g.f.demo.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author dongfei
 */

public interface HellWorldService {
    /**
     * 说些什么
     * @param words
     */
    void say(String words);

    void say(@NotBlank(message = "谁说的，你倒是说啊") String who, String words);

    void say(@Validated Hello hello);
}
