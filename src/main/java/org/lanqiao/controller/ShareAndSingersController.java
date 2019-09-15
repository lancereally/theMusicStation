package org.lanqiao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.json.JSONException;
import org.lanqiao.entity.*;
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
public class ShareAndSingersController {

    @Autowired
    ShareService shareService;

    @Autowired
    UsersService usersService;

    @Autowired
    SingerService singerService;

    @Autowired
    private SolrTemplate solrTemplate;


    @RequestMapping("/share/getAllShare")
    public PageInfo get(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

        PageHelper.startPage(pageNum, 3);

        List<Share> shareList = shareService.getAllShare();

        PageInfo<Share> pageInfo = new PageInfo<>(shareList);

        return pageInfo;
    }

    @RequestMapping("/share/addLikes")
    public Integer addLikes(@RequestParam Integer shareId){
        return shareService.updateShareLikesByPK(shareId);
    }

    @RequestMapping("/share/shareForward")
    public void insertShareForward(Share share, HttpServletRequest request, HttpServletResponse response)throws IOException {
        share.setShareLocation(GetPlaceByIp.getPlace(request));
        shareService.insertShareForward(share);
        response.sendRedirect("/share.html");
    }

    @RequestMapping("/share/getUser")
    public Users getUser(@RequestParam Integer userId){
        Users users = usersService.getShareUser_q(userId);
        return users;
    }

    @RequestMapping("/share/getStarUsers")
    public List<Singer> getStarUsers(){
        List<Singer> singerList = singerService.getStarByRand();
        return  singerList;
    }

    @RequestMapping("/share/gerOtherUsers")
    public List<Users> getOtherUsers(){
        return usersService.getOtherUsersByRand();
    }


    @RequestMapping("/share/getSongsBySolr")
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

    @RequestMapping("/share/shareMusicOrVideo")
    public void insertShareMusic(Share share , MultipartFile file, HttpServletResponse response, HttpServletRequest request) throws IOException {
        if(file.getSize() != 0){
            share.setShareAnnexUrl(new FileUploadGsq().uploadToDisk(file));
        }
        share.setShareLocation(GetPlaceByIp.getPlace(request));
        shareService.insertShareForward(share);
        response.sendRedirect("/share.html");
    }

    @RequestMapping("/share/becomeOtherFan")
    public Integer becomeOtherFan(Integer userId, Integer otherId){
        return usersService.becomeOtherFan(userId,otherId);
    }


    @RequestMapping("/share/getShareComment")
    public List<ShareComment> getShareComments(Integer shareId){
        return shareService.selectByShareId(shareId);
    }

    @RequestMapping("/share/insertShareComment")
    public Integer insertShareComment(ShareComment shareComment){
        return shareService.insertShareComment(shareComment);
    }

    @RequestMapping("/singer/getEnterSingers/first")
    public List<Singer> getEnterSingers(){
        return singerService.getEnterSinger(10);
    }

    @RequestMapping("/singer/getEnterSingers/second")
    public List<Singer> getEnterSingersSecond(){
        return singerService.getEnterSinger(0);
    }

    @RequestMapping("/singer/getHotSingers/second")
    public List<Singer> getHotSingersSecond(){
        return singerService.getHotSigner(0);
    }

    @RequestMapping("/singer/getHotSingers/first")
    public List<Singer> getHotSingersFirst(){
        return singerService.getHotSigner(10);
    }

    @RequestMapping("/singer/selectSingerByKeyWord")
    public List<Singer> getSingerBySolrWithKey(String singerKeyWord,String singerNameKeyWord){
        // 查询所有
        Query query = new SimpleQuery();

        //设置分页
        query.setOffset(0l); //开始索引(默认0)
        query.setRows(10);  //每页记录数(默认10)


        //设置排序规则
        Sort sort = new Sort(Sort.Direction.ASC, "singerId");
        query.addSort(sort);

        Criteria criteria = new Criteria("singerDescription").is(singerKeyWord);
        query.addCriteria(criteria);
        if (singerNameKeyWord.length() > 0){
            Criteria criteria1 = new Criteria("singerName").is(singerNameKeyWord.toLowerCase());
            query.addCriteria(criteria1);
        }
        //查询1
        ScoredPage<Singer> pages = solrTemplate.queryForPage("singers", query, Singer.class);

        return pages.getContent();
    }









//    private static final String solrUrl = "http://localhost:8983/solr/singers";

//    @RequestMapping("/singer/selectSingerByKeyWord")
//    public SolrDocumentList getSingerSolrWithKey(String singerKeyWord,String singerNameKeyWord) throws IOException, SolrServerException {
////        HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl)
////                .withConnectionTimeout(10000)
////                .withSocketTimeout(60000)
////                .build();
////        SolrQuery query = new SolrQuery();
////        query.set("q", "singerDescription:华语女歌手");
////        query.set("mm", "100%");
////        // 调用server的查询方法，查询索引库
////        QueryResponse response = solrClient.query(query);
////        // 查询结果
////        SolrDocumentList results = response.getResults();
////        // 查询结果总数
////        long cnt = results.getNumFound();
////        System.out.println("查询结果总数:" + cnt);
////        for (SolrDocument solrDocument : results) {
////            System.out.println(solrDocument.get("id"));
////            System.out.println(solrDocument.get("title"));
////        }
//
//        return null;
//    }
}
