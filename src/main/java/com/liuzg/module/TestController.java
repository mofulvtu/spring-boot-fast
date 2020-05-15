package com.liuzg.module;

import com.liuzg.dao.UserDao;
import com.liuzg.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *  Desc: test
 * </pre>
 *
 * @author liuzg
 * @date 2020/5/13 21:54
 **/
@Api(value = "测试", tags = "测试用例")
@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private UserDao userDao;

    @ApiOperation(value = "postUser", notes = "新增用户")
    @PostMapping(value = "/postUser")
    @ApiImplicitParam(value = "user", name = "user", dataType = "json", paramType = "json")
    public RestMessage postUser(@RequestBody User user) {
        return new RestMessage(userDao.insert(user));
    }

    @ApiOperation(value = "getUser", notes = "通过id获取用户")
    @GetMapping(value = "/getUser")
    @ApiImplicitParam(value = "id", name = "id", dataType = "int", paramType = "query", defaultValue = "1")
    public RestMessage getTest(@RequestParam(value = "id") int id) {
        return new RestMessage(userDao.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "putUser", notes = "更新用户")
    @PutMapping(value = "/putUser")
    @ApiImplicitParam(value = "user", name = "user", dataType = "json", paramType = "json")
    public RestMessage putTest(@RequestBody User user) {
        return new RestMessage(userDao.updateByPrimaryKey(user));
    }

    @ApiOperation(value = "deleteUser", notes = "通过id删除用户")
    @DeleteMapping(value = "/deleteUser")
    @ApiImplicitParam(value = "id", name = "id", dataType = "int", paramType = "int", defaultValue = "")
    public RestMessage deleteTest(@RequestParam(value = "id") int id) {
        return new RestMessage(userDao.deleteByPrimaryKey(id));
    }


}
