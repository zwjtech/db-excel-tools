package com.wql.database.tools.controller;

import com.wql.database.tools.domain.ConnectionParams;
import com.wql.database.tools.entity.ColumnInfo;
import com.wql.database.tools.service.SchemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 主页
 * Created by wendrewshay on 2019/05/31
 */
@Slf4j
@Controller
public class HomeController {

    @Autowired
    private SchemaService schemaService;

    /**
     * 查询所有表元信息
     * @param params 连接参数
     * @return List<TableInfo>
     */
    @GetMapping(value = "/queryTables")
    @ResponseBody
    public List queryTables(ConnectionParams params) {
        return schemaService.queryTables(params);
    }

    /**
     * 查询表字段信息
     * @param params    连接参数
     * @param tableName 表名称
     * @return ColumnInfo
     */
    @GetMapping(value = "/queryColumnsOf/{tableName}")
    @ResponseBody
    public List<ColumnInfo> queryColumnInfo(ConnectionParams params, @PathVariable(name = "tableName") String tableName) {
        return schemaService.queryColumnInfo(params, tableName);
    }

    @GetMapping(value = "export")
    public void export(HttpServletRequest request, HttpServletResponse response, ConnectionParams params) {

    }
}
