package com.mezo.athena.api.intranet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qzrs
 */
@RestController
@RequestMapping("/intranet")
public abstract class IntranetAbstractController {

    @RequestMapping("/magic/get")
    public String test() {
        return "测试";
    }

}
