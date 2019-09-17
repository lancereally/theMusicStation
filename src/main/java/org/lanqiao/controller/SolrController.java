package org.lanqiao.controller;

import org.lanqiao.entity.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class SolrController {

    @Autowired
    private SolrTemplate solrTemplate;

    @RequestMapping("/solr/selectSongsByInput")
    @ResponseBody
    public List<Songs> selectByInput(String input) {
        // 查询所有
        Query query1 = new SimpleQuery();
        Query query2 = new SimpleQuery();
        Query query3 = new SimpleQuery();

        //设置分页
//        query.setOffset(0L); //开始索引(默认0)
//        query.setRows(2);  //每页记录数(默认10)

        //设置排序规则
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        query1.addSort(sort);

        //设置查询条件
        Criteria criteria1 = new Criteria("songName").is(input);
        query1.addCriteria(criteria1);
        Criteria criteria2 = new Criteria("singerName").is(input);
        query2.addCriteria(criteria2);
        Criteria criteria3 = new Criteria("albumName").is(input);
        query3.addCriteria(criteria3);

        //查询
        ScoredPage<Songs> pages = solrTemplate.queryForPage("songs", query1, Songs.class);
        List<Songs> content = pages.getContent();
        pages = solrTemplate.queryForPage("songs", query2, Songs.class);
        List<Songs> content2 = pages.getContent();
        pages = solrTemplate.queryForPage("songs", query3, Songs.class);
        List<Songs> content3 = pages.getContent();

        //HestSet去重
        List<Songs> songsList = new ArrayList<>();
        songsList.addAll(content);
        songsList.addAll(content2);
        songsList.addAll(content3);
        songsList = new ArrayList<>(new HashSet<Songs>(songsList));
        return songsList;
    }
}
