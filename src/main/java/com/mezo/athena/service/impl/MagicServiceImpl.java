package com.mezo.athena.service.impl;

import com.mezo.athena.service.MagicService;
import org.springframework.stereotype.Service;

@Service
public class MagicServiceImpl implements MagicService {

    @Override
    public String info() {
        return "只要你记得我，我不介意整个世界都把我遗忘了。";
    }
}
