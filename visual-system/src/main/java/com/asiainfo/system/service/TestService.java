package com.asiainfo.system.service;



import com.asiainfo.system.domain.Phone;
import com.asiainfo.system.domain.UserTable;

import java.util.List;

public interface TestService {
    List<UserTable> getOne();

    List<Phone> getPhone();
}
