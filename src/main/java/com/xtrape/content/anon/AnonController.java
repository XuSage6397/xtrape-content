package com.xtrape.content.anon;

import com.xtrape.common.core.utils.StringUtils;
import com.xtrape.common.core.web.domain.AjaxResult;
import com.xtrape.common.core.web.page.TableDataInfo;
import com.xtrape.common.security.web.controller.BaseController;
import com.xtrape.content.blog.domain.CmsBlog;
import com.xtrape.content.blog.domain.CmsBlogSearch;
import com.xtrape.content.blog.service.ICmsBlogService;
import com.xtrape.content.feign.SystemFeignService;
import com.xtrape.content.fileInfo.service.ISysFileInfoService;
import com.xtrape.content.tag.domain.CmsTag;
import com.xtrape.content.tag.service.ICmsTagService;
import com.xtrape.content.type.domain.CmsType;
import com.xtrape.content.type.service.ICmsTypeService;
import com.xtrape.system.service.ISysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/anon")
public class AnonController extends BaseController {
    @Autowired
    private ICmsBlogService cmsBlogService;

    @Autowired
    private ICmsTypeService cmsTypeService;

    @Autowired
    private ICmsTagService cmsTagService;

    @Autowired
    private ISysPermissionService permissionService;

    @Autowired
    private ISysFileInfoService sysFileInfoService;

    @Autowired
    SystemFeignService systemFeignService;

    /**
     * list
     */
    @GetMapping("/list/{categories}")
    public TableDataInfo list(@PathVariable(value = "categories", required = false) String categories) {
        String[] categoryArray = categories.split(",");
        startPage();
        CmsBlogSearch cmsBlogSearch = new CmsBlogSearch();
        cmsBlogSearch.setTypes(categoryArray);
        cmsBlogSearch.setStatuses(new int[] { 1 });

        List<CmsBlog> list = cmsBlogService.inquire(cmsBlogSearch);
        return getDataTable(list);
    }

    /**
     * 首页获取文章详细信息
     */
    @GetMapping(value = {"/pickup/{id}"})
    public AjaxResult pickup(@PathVariable(value = "id", required = false) Long id) {
        AjaxResult ajax = AjaxResult.success();
        CmsType cmsType = new CmsType();
        CmsTag cmsTag = new CmsTag();
        ajax.put("types", cmsTypeService.selectCmsTypeList(cmsType));
        ajax.put("tags", cmsTagService.selectCmsTagList(cmsTag));
        if (StringUtils.isNotNull(id)) {
            ajax.put(AjaxResult.DATA_TAG, cmsBlogService.selectCmsBlogById(id));
        }
        return ajax;
    }
}
