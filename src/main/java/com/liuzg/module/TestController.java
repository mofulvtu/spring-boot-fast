package com.liuzg.module;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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


    @ApiOperation(value = "getTest", notes = "pgettest测试说明1")
    @GetMapping(value = "/getTest")
    @ApiImplicitParam(value = "code", name = "code", dataType = "string", paramType = "query", defaultValue = "abc")
    public RestMessage getTest(String code) {
        return new RestMessage(code);
    }

    @ApiOperation(value = "putTest", notes = "putTest测试说明2")
    @PutMapping(value = "/putTest")
    @ApiImplicitParam(value = "code", name = "code", dataType = "string", paramType = "query", defaultValue = "abc")
    public RestMessage putTest(String code) {
        return new RestMessage(code);
    }

    @ApiOperation(value = "deleteTest", notes = "deleteTest测试说明3")
    @DeleteMapping(value = "/deleteTest")
    @ApiImplicitParam(value = "code", name = "code", dataType = "string", paramType = "query", example = "abcefg")
    public RestMessage deleteTest(@RequestParam(value = "code") String code) {
        return new RestMessage(code);
    }


}
