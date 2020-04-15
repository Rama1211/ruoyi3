package com.ruoyi.web.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.DormRoomService.MisCampusService;
import com.ruoyi.system.service.DormRoomService.MisFloorService;
import com.ruoyi.system.service.DormRoomService.MisPeropertyService;
import com.ruoyi.system.service.MisStudentFacultyService;
import com.ruoyi.system.service.MisStudentProfessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用请求处理
 * 
 * @author ruoyi
 */
@Controller
public class CommonController
{
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private MisStudentFacultyService facultyService;

    @Autowired
    private MisStudentProfessionService professionService;

    @Autowired
    private MisCampusService misCampusService;

    @Autowired
    private MisFloorService misFloorService;

    @Autowired
    private MisPeropertyService peropertyService;

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            if (!FileUtils.isValidFilename(fileName))
            {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = Global.getDownloadPath() + fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(filePath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = Global.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        // 本地资源路径
        String localPath = Global.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }

    /**
     *院系下拉框查询
     */
    @GetMapping("/common/studentFaculty")
    public @ResponseBody List<MisFaculty> studentFaculty()
    {
        List<MisFaculty> list = facultyService.selectFacultyList();
        return list ;
    }

    /**
     *专业下拉框查询
     */
    @GetMapping("/common/studentProfession")
    public @ResponseBody List<MisProfession> studentProfession(String facultyId)
    {
            if(facultyId.equals("null")){
                facultyId="1";
            }
        List<MisProfession> list =professionService.selectProfessionList(facultyId);
        return list ;
    }
    /**
     *校区下拉框查询
     */
    @GetMapping("/common/studentScampus")
    public @ResponseBody List<MiScampus> MiScampusFaculty()
    {
        MiScampus miScampus=new MiScampus();
        List<MiScampus> list = misCampusService.selectScampusList(miScampus);
        return list;
    }

    /**
     *楼栋下拉框查询
     */
    @GetMapping("/common/studentfloor")
    public @ResponseBody List<MisFloor> studentfloor(String campusId)
    {
        if(campusId.equals("null")){
            campusId="1";
        }
        List<MisFloor> list =misFloorService.selectFloorByCampusId(campusId,"");
        return list;
    }

    /**
     *财物下拉框查询
     */
    @GetMapping("/common/property")
    public @ResponseBody List<DimProperty> property()
    {
        List<DimProperty> list =peropertyService.selectDimPropertyAll();
        return list;
    }

}
