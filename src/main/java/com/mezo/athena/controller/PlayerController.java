package com.mezo.athena.controller;

import com.mezo.athena.common.config.ServiceSession;
import com.mezo.athena.common.result.ReturnDataResult;
import com.mezo.athena.demain.PlayerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private ServiceSession serviceSession;
    /**
     * 添加服务
     * @param vo
     */
    @PostMapping
    public ReturnDataResult createPlayerService(@RequestBody PlayerVO vo) {
        serviceSession.add(vo.getId(),vo);
        return ReturnDataResult.getSuccess();
    }

    /**
     * 修改服务
     * @param vo
     */
    @PutMapping
    public ReturnDataResult modifyPlayerService(@RequestBody PlayerVO vo) {
        serviceSession.update(vo.getId(),vo);
        return ReturnDataResult.getSuccess();
    }

    /**
     * 查询详情
     * @param id
     */
    @GetMapping("/{id}")
    public ReturnDataResult queryPlayerService(@PathVariable("id")Integer id) {
        Object vo = serviceSession.get(id);
        return ReturnDataResult.getSuccess("查询成功",vo);
    }

    /**
     * 查询列表
     */
    @GetMapping
    public ReturnDataResult listPlayerService() {
        List list = serviceSession.list();
        return ReturnDataResult.getSuccess("查询成功",list);
    }

}
