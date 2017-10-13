package com.dwd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dwd.inter.IUserOperation;
import com.dwd.model.Article;

@Controller
public class UserController {
	@Autowired
    IUserOperation userMapper;

    @RequestMapping("/list")
    public ModelAndView listall(HttpServletRequest request,HttpServletResponse response){
        List<Article> articles=userMapper.getUserArticles(1); 
        for(Article article:articles) {
        	System.out.println(article.getContent());
        }
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("articles",articles);
        return mav;
    }
    
    @RequestMapping("/jsontest")
    public @ResponseBody List<Article> getAll() {
    	List<Article> articles=userMapper.getUserArticles(1);
		return articles;
    	
    }
    @RequestMapping("/stringtest")
    public @ResponseBody List get(Integer id) {
    	List<Article> articles=userMapper.getUserArticles(id);
    	List<Map> ne=new ArrayList<Map>();
    	  for(Article article:articles) {
          	Map<String, String> map=new HashMap<String, String>();
          	map.put("id", String.valueOf(article.getId()));
          	map.put("userid", String.valueOf(article.getUser().getId()));
          	map.put("title", article.getTitle());
          	map.put("content", article.getContent());
          	ne.add(map);
          }
    	  return ne;
    }
}
