package url.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import url.model.Stats;
import url.model.Url;
import url.service.UrlService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    void getAccessUrl(@PathVariable(value = "id") long id, HttpServletResponse response) throws IOException {
        String url = urlService.getUrl(id);

        response.setStatus(301);
        response.sendRedirect(url);
    }

    @RequestMapping(value = "/{id}/stats", method = RequestMethod.GET)
    @ResponseBody
    Stats getAccessStats(@PathVariable(value = "id") long id, HttpServletResponse response) throws IOException {
        long stats = urlService.getStats(id);
        response.setStatus(200);

        return new Stats(stats);
    }
}