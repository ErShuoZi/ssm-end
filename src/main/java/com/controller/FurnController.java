package com.controller;

import com.bean.Furn;
import com.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.FurnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
public class FurnController {

    private static class RequestObject {
        private Integer pageNum = 1;
        private Integer pageSize = 5;

        public Integer getPageNum() {
            return pageNum;
        }

        public void setPageNum(Integer pageNum) {
            this.pageNum = pageNum;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public String getSearch() {
            return search;
        }

        public void setSearch(String search) {
            this.search = search;
        }

        private String search = "";

        // 省略 getter 和 setter 方法
    }
//    注入Service
    @Resource
    private FurnService furnService;
    //相应客户端添加请求
    @RequestMapping("/save")
    public Msg save(@RequestBody Furn furn){
        furnService.save(furn);
        //返回成功信息
        Msg success = Msg.success();
        return success;
    }

    @RequestMapping("/all")
    @ResponseBody
    public Msg listAllFurns(){
        List<Furn> all = furnService.findAll();
        Msg success = Msg.success().add("furnList",all);
        return success;
    }


    @PutMapping("/update")
    @ResponseBody
    public Msg updateFurn(@RequestBody Furn furn){
        furnService.update(furn);
        Msg success = Msg.success();
        return success;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Msg del(@PathVariable Integer id){
        furnService.delete(id);
        Msg success = Msg.success();
        return success;
    }


    /**
     * @param pageNum :要显示第一页
     * @param pageSize:每页显示几条记录
     * @return
     */
//    分页
@RequestMapping("/findFurnByPage")
@ResponseBody
public Msg findFurnByPage(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
    //设置分页参数
    PageHelper.startPage(pageNum,pageSize);
    List<Furn> furnList = furnService.findAll();
    //将结果封装到PageInfo
    //包含了分页的各个信息
    PageInfo pageInfo = new PageInfo(furnList,pageSize);

    //将pageInfo封装到Msg
    return Msg.success().add("pageInfo",pageInfo);
    }


    //条件分页
//    @RequestMapping("/findFurnByConditionPage")
//    @ResponseBody
//    public Msg findFurnByConditionPage(@RequestParam(defaultValue = "1") Integer pageNum,
//                                       @RequestParam(defaultValue = "5") Integer pageSize,
//                                       @RequestParam(defaultValue = "") String search){
//        //设置分页参数
//        PageHelper.startPage(pageNum,pageSize);
//        List<Furn> furnList = furnService.findByCondition(search);
//        //将结果封装到PageInfo
//        //包含了分页的各个信息
//        PageInfo pageInfo = new PageInfo(furnList,pageSize);
//        //将pageInfo封装到Msg
//        return Msg.success().add("pageInfo",pageInfo);
//        }



    @RequestMapping("/findFurnByConditionPage")
    @ResponseBody
    public Msg findFurnByConditionPage(@RequestBody RequestObject requestObject){
        Integer pageNum = requestObject.getPageNum();
        Integer pageSize = requestObject.getPageSize();
        String search = requestObject.getSearch();
        //设置分页参数
        PageHelper.startPage(pageNum,pageSize);
        List<Furn> furnList = furnService.findByCondition(search);
        System.out.println(furnList);
        //将结果封装到PageInfo
        //包含了分页的各个信息
        PageInfo pageInfo = new PageInfo(furnList,pageSize);
        //将pageInfo封装到Msg
        return Msg.success().add("pageInfo",pageInfo);
    }
    }





