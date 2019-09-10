package org.lanqiao.mapper;

import org.lanqiao.entity.ShareComment;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareCommentMapper {
    int deleteByPrimaryKey(Integer scId);

    int insert(ShareComment record);

    int insertSelective(ShareComment record);

    ShareComment selectByPrimaryKey(Integer scId);

    int updateByPrimaryKeySelective(ShareComment record);

    int updateByPrimaryKey(ShareComment record);
}