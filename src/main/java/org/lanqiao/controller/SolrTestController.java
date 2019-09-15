package org.lanqiao.controller;

import org.lanqiao.entity.Songs;
import org.lanqiao.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class SolrTestController {

    @Autowired
    private SolrTemplate solrTemplate;

    @RequestMapping("/song/select")
    @ResponseBody
    public List<Songs> select() {
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
        Criteria criteria = new Criteria("singerName").is("zhoujielun");
        //条件二 歌名里有 好
        Criteria criteria1 = new Criteria("songName").is("好");

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



}
