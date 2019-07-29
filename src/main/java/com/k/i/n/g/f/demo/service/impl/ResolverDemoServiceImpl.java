package com.k.i.n.g.f.demo.service.impl;

import com.k.i.n.g.f.demo.entity.AuthUser;
import com.k.i.n.g.f.demo.resolver.LoginUser;
import com.k.i.n.g.f.demo.service.ResolverDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author dongfei
 */
@Service
@Slf4j
public class ResolverDemoServiceImpl implements ResolverDemoService {
    /**
     * 默认HandlerMethodArgumentResolver @LoginUser 在service这一层就没用了
     * org.springframework.web.method.support.HandlerMethodArgumentResolver
     * @param user
     */
    @Override
    public void demo(@LoginUser AuthUser user) {
        log.warn("do noThing");
    }
}
