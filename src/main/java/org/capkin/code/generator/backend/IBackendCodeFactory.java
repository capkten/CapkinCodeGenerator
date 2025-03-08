package org.capkin.code.generator.backend;

public interface IBackendCodeFactory {

    public IBackendCodeFill getBackendCodeFill(int type, String database);
}
