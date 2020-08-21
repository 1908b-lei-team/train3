package com.fh.mapper;
import com.fh.domain.UserFaceInfo;
import com.fh.dto.FaceUserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface MybatisUserFaceInfoMapper {

    List<UserFaceInfo> findUserFaceInfoList();

    void insertUserFaceInfo(UserFaceInfo userFaceInfo);

    List<FaceUserInfo> getUserFaceInfoByGroupId(Integer groupId);

    UserFaceInfo findFaceInfoByName(String name);
}
