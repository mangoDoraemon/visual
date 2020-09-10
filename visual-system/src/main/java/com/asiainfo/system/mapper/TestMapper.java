package com.asiainfo.system.mapper;



import com.asiainfo.system.domain.Phone;
import com.asiainfo.system.domain.UserTable;

import java.util.List;

public interface TestMapper {

    List<UserTable> getOne();

    List<Phone> getPhone();
}
