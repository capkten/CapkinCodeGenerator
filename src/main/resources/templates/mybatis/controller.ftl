<#if isAutoImport?exists && isAutoImport==true>
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
</#if>

/**
 * @description 用户控制器
 * @author ${authorName}
 * @date ${.now?string('yyyy-MM-dd')}
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
    * 新增
    * @author ${authorName}
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    @RequestMapping("/insert")
    public Object insert(User user){
        return userService.insert(user);
    }

    /**
    * 删除
    * @author ${authorName}
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    @RequestMapping("/delete")
    public Object delete(int id){
        return userService.delete(id);
    }

    /**
    * 更新
    * @author ${authorName}
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    @RequestMapping("/update")
    public Object update(User user){
        return userService.update(user);
    }

    /**
    * 查询 根据主键 id 查询
    * @author ${authorName}
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    @RequestMapping("/load")
    public Object load(int id){
        return userService.load(id);
    }

    /**
    * 查询 分页查询
    * @author ${authorName}
    * @date ${.now?string('yyyy/MM/dd')}
    **/
    @RequestMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return userService.pageList(offset, pagesize);
    }

}