package com.liuzg.module;

import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/***
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2017/04/20 14:01
 */
@Api(value = "测试",tags = "测试用例")
@RestController
@RequestMapping("/api/test")
public class TestController {


    @ApiOperation(value = "puttest",notes = "puttest测试说明2")
    @PutMapping(value = "/puttest")
    @ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "query",defaultValue = "abc")
    public RestMessage puttest(String code){
        return new RestMessage(code);
    }

    @ApiOperation(value = "deletetest",notes = "deletetest测试说明2")
    @DeleteMapping(value = "/deletetest")
    @ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "query",example = "abcefg")
    public RestMessage deletetest(@RequestParam(value = "code") String code){
        return new RestMessage(code);
    }



    @PostMapping("/reqbody3")
    @ApiOperation(value = "header参数",notes = "header参数")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "query"),
            @ApiImplicitParam(value = "headerparam",name = "headerparam",dataType = "string",paramType = "header"),
            @ApiImplicitParam(value = "page",name = "page",dataType = "int",paramType = "query"),
            @ApiImplicitParam(value = "page1",name = "page1",dataType = "Long",paramType = "query")
    })
    public RestMessage reqbody3(@RequestHeader(value = "headerparam") String headerparam,@RequestParam(value = "code") String code,
                                @RequestParam(value = "page") int page,@RequestParam(value = "page1") Long page1){
        return new RestMessage(ImmutableMap.of("code",code,"header",headerparam,"page",page,"page1",page1));
    }




}
