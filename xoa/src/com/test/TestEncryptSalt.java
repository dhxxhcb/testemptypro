package com.test;

import com.xoa.service.users.UsersService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:config/spring/springs-beans.xml"})
public class TestEncryptSalt {

    @Resource
    UsersService usersService;
    @org.junit.Test
    public void testMd5WithSalt(){

        String encryptString = usersService.getEncryptString("123,./a");
        System.out.println(encryptString);
        System.out.println(encryptString);
        System.out.println(encryptString);
        System.out.println(encryptString);
        System.out.println(encryptString);
        System.out.println(encryptString);
        System.out.println(encryptString);


    }

    @org.junit.Test
    public void testCheckPassWord(){

        Boolean isRight = usersService.checkPassWord("hcb", "123,./a");
        System.out.println(isRight);
        System.out.println(isRight);
        System.out.println(isRight);
        System.out.println(isRight);
        System.out.println(isRight);

    }

}
