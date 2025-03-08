package org.capkin.code.generator.backend;

import cn.hutool.core.lang.Singleton;
import org.capkin.code.generator.backend.impl.MybatisCodeFill;
import org.capkin.code.generator.backend.impl.MybatisPlusCodeFill;

public class BackendCodeFactory implements IBackendCodeFactory {

    @Override
    public IBackendCodeFill getBackendCodeFill(int type, String database) {
        if (type == 1 && database.equals("mysql")) {
            return Singleton.get(MybatisCodeFill.class);
        } else if (type == 2 && database.equals("mysql")) {
            return Singleton.get(MybatisPlusCodeFill.class);
        }
        return null;
    }
}
