package com.asiainfo.system.mapper;

import com.asiainfo.common.core.domain.entity.SysUiData;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author wangjingyuan
 */
@Repository
public interface SysUiDataMapper extends Mapper<SysUiData> {
    /**
     * 更新状态
     * @param reportId
     * @param deleted
     */
    void updateStatusById(@Param("reportId") String reportId,@Param("deleted") String deleted);
}
