package com.example.personal_info_module.vo.response;

import java.time.LocalDate;
import java.util.List;

import com.example.personal_info_module.entity.News;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NewsResponse {
	
	private List<NewsResponse> list;
	
	private News news;
	
	private Integer newsId;

	private Integer mainCategory;

	private Integer subCategory;

	private String title;

	private String text;
	
	private Boolean open;
	
	private LocalDate creatDate;
	
	private LocalDate updataDate;
	
	private LocalDate openDate;
	
	private String message;

	public List<NewsResponse> getList() {
		return list;
	}

	public void setList(List<NewsResponse> list) {
		this.list = list;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public Integer getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(Integer mainCategory) {
		this.mainCategory = mainCategory;
	}

	public Integer getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Integer subCategory) {
		this.subCategory = subCategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public LocalDate getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(LocalDate creatDate) {
		this.creatDate = creatDate;
	}

	public LocalDate getUpdataDate() {
		return updataDate;
	}

	public void setUpdataDate(LocalDate updataDate) {
		this.updataDate = updataDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NewsResponse(List<NewsResponse> list, Integer newsId, Integer mainCategory, Integer subCategory, String title,
			String text, Boolean open, LocalDate creatDate, LocalDate updataDate, String message) {
		super();
		this.list = list;
		this.newsId = newsId;
		this.mainCategory = mainCategory;
		this.subCategory = subCategory;
		this.title = title;
		this.text = text;
		this.open = open;
		this.creatDate = creatDate;
		this.updataDate = updataDate;
		this.message = message;
	}

	public NewsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsResponse(String message) {
		super();
		this.message = message;
	}

	public NewsResponse(List<NewsResponse> list) {
		super();
		this.list = list;
	}

	public NewsResponse(Integer newsId, Integer mainCategory, Integer subCategory, String title, String text,
			Boolean open, LocalDate creatDate, LocalDate updataDate) {
		super();
		this.newsId = newsId;
		this.mainCategory = mainCategory;
		this.subCategory = subCategory;
		this.title = title;
		this.text = text;
		this.open = open;
		this.creatDate = creatDate;
		this.updataDate = updataDate;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public NewsResponse(News news) {
		super();
		this.news = news;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}

	public NewsResponse(List<NewsResponse> list, News news, Integer newsId, Integer mainCategory, Integer subCategory,
			String title, String text, Boolean open, LocalDate creatDate, LocalDate updataDate, LocalDate openDate,
			String message) {
		super();
		this.list = list;
		this.news = news;
		this.newsId = newsId;
		this.mainCategory = mainCategory;
		this.subCategory = subCategory;
		this.title = title;
		this.text = text;
		this.open = open;
		this.creatDate = creatDate;
		this.updataDate = updataDate;
		this.openDate = openDate;
		this.message = message;
	}

	public NewsResponse(List<NewsResponse> list, News news, Integer newsId, Integer mainCategory, Integer subCategory,
			String title, String text, Boolean open, LocalDate creatDate, LocalDate updataDate, LocalDate openDate) {
		super();
		this.list = list;
		this.news = news;
		this.newsId = newsId;
		this.mainCategory = mainCategory;
		this.subCategory = subCategory;
		this.title = title;
		this.text = text;
		this.open = open;
		this.creatDate = creatDate;
		this.updataDate = updataDate;
		this.openDate = openDate;
	}

	
	
}
