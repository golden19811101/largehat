package com.largehat.api.modules.security.service;


import com.largehat.api.modules.system.domain.SysDept;

import java.util.List;
import java.util.Set;

public interface DataScopeService {


    Set<Long> getDeptIds();

    List<Long> getDeptChildren(List<SysDept> deptList);

}
