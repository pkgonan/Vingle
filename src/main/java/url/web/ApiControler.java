package url.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import url.model.Url;
import url.service.UrlService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ApiControler {
    @Autowired
    UrlService urlService;

    @RequestMapping(value = "/register.json", method = RequestMethod.POST)
    @ResponseBody
    Url registUrl(@RequestParam(value = "url") String url, HttpServletRequest request, HttpServletResponse response) {
        long id = urlService.regist(url);

        if (urlService.isExist(url))
            response.setStatus(200);
        else response.setStatus(201);
        response.setContentType("application/json");

        return new Url(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" + id);
    }
}