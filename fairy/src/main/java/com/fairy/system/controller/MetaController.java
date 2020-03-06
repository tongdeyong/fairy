package com.fairy.system.controller;

import com.alibaba.fastjson.JSON;
import com.fairy.common.utils.PageUtils;
import com.fairy.common.vo.Result;
import com.fairy.system.model.Column;
import com.fairy.system.model.Table;
import com.fairy.system.service.MetaService;
import com.fairy.system.vo.ColumnVO;
import com.fairy.system.vo.SqlQueryVO;
import com.fairy.system.vo.TableVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author deyong_tong
 */
@Slf4j
@RestController
@RequestMapping("/system/meta")
public class MetaController extends BaseController {

    @Autowired
    private MetaService metaService;

    @GetMapping("/table/list")
    public Result tableList(TableVO tableVO) {
        List<Table> tableList = metaService.listTable(tableVO);
        return commonReturnResult(tableList);
    }

    @GetMapping("/column/list")
    public Result tableList(ColumnVO columnVO) {
        List<Column> columnList = metaService.listColumn(columnVO);
        return commonReturnResult(columnList);
    }

    @PostMapping("/query")
    public Result query(@RequestBody SqlQueryVO queryVO) {
        try {
            if (StringUtils.isBlank(queryVO.getSql())) {
                return Result.error("请输入sql");
            }
            if (queryVO.getSql().contains("update") || queryVO.getSql().contains("insert") || queryVO.getSql().contains(
                    "delete")) {
                return Result.error("仅仅支持select语句");
            }
            List<Map<String, Object>> data = metaService.querySql(queryVO.getSql());
            return Result.ok(PageUtils.page(data, queryVO.getPageNum(), queryVO.getPageSize()), queryVO.getPageNum(),
                    queryVO.getPageSize(), data.size());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/generateCode")
    public void generateSql(@RequestBody TableVO tableVO, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("utf-8");
            ServletOutputStream outputStream = response.getOutputStream();
            if (CollectionUtils.isEmpty(tableVO.getTableNameList())) {
                response.setContentType("application/json");
                outputStream.write(JSON.toJSONString(Result.error("请选择表")).getBytes(StandardCharsets.UTF_8));
                outputStream.close();
                return;
            }
            ByteArrayOutputStream byteArrayOutputStream = metaService.generateSql(tableVO);
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=code.zip");
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
