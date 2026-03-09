package com.zlq.controller;

import com.zlq.pojo.Emp;
import com.zlq.pojo.LoginInfo;
import com.zlq.pojo.Result;
import com.zlq.service.EmpService;
import com.zlq.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录 , {}", emp);
        LoginInfo loginInfo = loginService.login(emp);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误~");
    }

}