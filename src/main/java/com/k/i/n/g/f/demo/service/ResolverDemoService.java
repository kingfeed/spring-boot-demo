package com.k.i.n.g.f.demo.service;

import com.k.i.n.g.f.demo.entity.AuthUser;
import com.k.i.n.g.f.demo.resolver.LoginUser;

/**
 * @author dongfei
 */
public interface ResolverDemoService {

    /**
     * nothing
     * @param user
     */
    void demo(@LoginUser AuthUser user);
}
