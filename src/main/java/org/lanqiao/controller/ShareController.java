package org.lanqiao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.json.JSONException;
import org.lanqiao.entity.Share;
import org.lanqiao.entity.Singer;
import org.lanqiao.entity.Songs;
import org.lanqiao.entity.Users;
import org.lanqiao.service.ShareService;
import org.lanqiao.service.SingerService;
import org.lanqiao.service.UsersService;
import org.lanqiao.util.FileUploadGsq;
import org.lanqiao.util.GetPlaceByIp;
import org.lanqiao.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/share")
public class ShareController {

    @Autowired
    ShareService shareService;

    @Autowired
    UsersService usersService;

    @Autowired
    SingerService singerService;

    @Autowired
    private SolrTemplate solrTemplate;


//    @RequestMapping("/apiTest")
//    @ResponseBody
//    public String test(HttpServletRequest request) throws IOException, JSONException {
//        String m = new GetPlaceByIp().getPlace(request);
//        return m;
//    }


    @RequestMapping("/getAllShare")
    public PageInfo get(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

        PageHelper.startPage(pageNum, 3);

        List<Share> shareList = shareService.getAllShare();

        PageInfo<Share> pageInfo = new PageInfo<>(shareList);

        return pageInfo;
    }

    @RequestMapping("/addLikes")
    public Integer addLikes(@RequestParam Integer shareId){
        return shareService.updateShareLikesByPK(shareId);
    }

    @RequestMapping("/shareForward")
    public void insertShareForward(Share share, HttpServletRequest request, HttpServletResponse response)throws IOException {
        share.setShareLocation(new GetPlaceByIp().getPlace(request));
        shareService.insertShareForward(share);
        response.sendRedirect("/share.html");
    }

    @RequestMapping("/getUser")
    public Users getUser(@RequestParam Integer userId){
        Users users = usersService.getShareUser_q(userId);
        return users;
    }

    @RequestMapping("/getStarUsers")
    public List<Singer> getStarUsers(){
        List<Singer> singerList = singerService.getStarByRand();
        return  singerList;
    }

    @RequestMapping("/gerOtherUsers")
    public List<Users> getOtherUsers(){
        return usersService.getOtherUsersByRand();
    }


    @RequestMapping("/getSongsBySolr")
    public List<Songs> getSongs(@RequestParam String songKey){
        // 查询所有
        Query query = new SimpleQuery();
        Query query2 = new SimpleQuery();

        //设置分页
        query.setOffset(0l); //开始索引(默认0)
        query.setRows(2);  //每页记录数(默认10)

        //设置排序规则
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        query.addSort(sort);

        // 设置条件1 歌名为zhoujielun
        Criteria criteria = new Criteria("singerName").is(songKey);
        //条件二 歌名里有 好
        Criteria criteria1 = new Criteria("songName").is(songKey);

        query.addCriteria(criteria);
        //查询1
        ScoredPage<Songs> pages = solrTemplate.queryForPage("songs", query, Songs.class);
        List<Songs> content = pages.getContent();


        query2.addCriteria(criteria1);
        //查询2
        pages = solrTemplate.queryForPage("songs", query2, Songs.class);
        List<Songs> content2 = pages.getContent();

        //HestSet去重
        List<Songs> songsList = new ArrayList<>();
        songsList.addAll(content);
        songsList.addAll(content2);
        songsList = new ArrayList<>(new HashSet<Songs>(songsList));
        return songsList;
    }

    @RequestMapping("/shareMusic")
    public void insertShareMusic(Share share , MultipartFile file, HttpServletResponse response, HttpServletRequest request) throws IOException {
        if(file.getSize() != 0){
            share.setShareAnnexUrl(new FileUploadGsq().uploadToDisk(file));
        }
        share.setShareLocation(new GetPlaceByIp().getPlace(request));
        shareService.insertShareForward(share);
        response.sendRedirect("/share.html");
    }



}
