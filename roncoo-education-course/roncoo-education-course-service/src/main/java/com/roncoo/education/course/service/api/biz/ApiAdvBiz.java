package com.roncoo.education.course.service.api.biz;

import cn.hutool.core.collection.CollectionUtil;
import com.roncoo.education.course.service.api.bo.AdvBO;
import com.roncoo.education.course.service.api.dto.AdvDTO;
import com.roncoo.education.course.service.api.dto.AdvListDTO;
import com.roncoo.education.course.dao.AdvDao;
import com.roncoo.education.course.dao.impl.mapper.entity.Adv;
import com.roncoo.education.util.base.PageUtil;
import com.roncoo.education.util.base.Result;
import com.roncoo.education.util.enums.StatusIdEnum;
import com.roncoo.education.util.tools.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 广告信息
 *
 * @author wujing
 */
@Component
public class ApiAdvBiz {

    @Autowired
    private AdvDao advDao;

    public Result<AdvListDTO> list(AdvBO advBO) {
        AdvListDTO dto = new AdvListDTO();
        // 开始时间和结束时间
        List<Adv> advList = advDao.listByPlatShowAndStatusIdAndBeginTimeAndEndTime(advBO.getPlatShow(), StatusIdEnum.YES.getCode(), DateUtil.parseDate("2019-07-04", "yyyy-MM-dd"), DateUtil.parseDate("2019-07-03", "yyyy-MM-dd"));
        if (CollectionUtil.isNotEmpty(advList)) {
            dto.setAdvList(PageUtil.copyList(advList, AdvDTO.class));
        }
        return Result.success(dto);
    }

}
