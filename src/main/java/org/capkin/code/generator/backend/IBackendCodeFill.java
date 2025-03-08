package org.capkin.code.generator.backend;

import org.capkin.code.generator.backend.model.ProjectModel;
import org.capkin.code.parse.model.TableInfo;

import java.util.List;

public interface IBackendCodeFill {

    public ProjectModel fillCode(List<TableInfo> tableInfoList, String packageName, String author, Boolean isSwagger);

}
