package com.fh.service.openAnAccount;

import com.fh.common.ServerResponse;
import com.fh.mapper.openAnAccount.OpenAnAccountMapper;
import com.fh.model.OpenAnAccount;
import com.fh.param.OpenAnAccountParam;
import com.fh.vo.OpenAnAccountVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OpenAnAccountServiceImpl implements OpenAnAccountService {

    @Resource
    private OpenAnAccountMapper openAnAccountMapper;

    @Override
    public ServerResponse queryList() {
        List<OpenAnAccount> openAnAccountList = openAnAccountMapper.selectList(null);
        return ServerResponse.successMethod(openAnAccountList);
    }

    @Override
    public void insertOpenAnAccount(OpenAnAccount openAnAccount) {

        openAnAccountMapper.insert(openAnAccount);
    }

    @Override
    public void updateOpenAnAccount(OpenAnAccount openAnAccount) {

        openAnAccountMapper.updateById(openAnAccount);
    }

    @Override
    public void deleteOpenAnAccount(Integer id) {

        openAnAccountMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> idList) {

        openAnAccountMapper.deleteBatchIds(idList);
    }

    /**
     * 分页
     * @param openAnAccountParam
     * @return
     */
    @Override
    public ServerResponse queryListPage(OpenAnAccountParam openAnAccountParam) {
        ///查询分页的数据

        //查询总条数
        Integer count = openAnAccountMapper.selCount();
        //把总条数放入page
        openAnAccountParam.setCount(count);
        Integer startNum =(openAnAccountParam.getCurrentPage()-1)*openAnAccountParam.getPagesize();
        openAnAccountParam.setStartNum(startNum);
        List<OpenAnAccountVo> list = openAnAccountMapper.queryListPage(openAnAccountParam);
        openAnAccountParam.setList(list);

        return ServerResponse.successMethod(openAnAccountParam);
    }
}
