package com.rqy.study.controller.swagger;

import com.rqy.study.util.RestResponse;
import com.rqy.study.util.RestfulStatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * restful风格文档测试访问路径:http://localhost:8080/swagger-ui.html
 *
 * @Author renqingyang
 * @create 2020/9/18 5:34 PM
 */
@Slf4j
@RestController
@RequestMapping("/swagger")
@Api("swaggerDemoController相关的api")
public class SwaggerController {


    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ApiOperation(value = "商品新增", notes = "新增数据库中某个的商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, paramType="query", dataType="String"),
    })
    public RestResponse addCategory(@RequestParam(value = "name", defaultValue = "") String name) {
        log.info("开始新增某个商品信息");
        RestResponse restResponse = new RestResponse();
        restResponse.setStatus(RestfulStatusCode.OK.code());
        restResponse.setMsg("新增成功");
        restResponse.setResult(name);
        return restResponse;
    }


}
