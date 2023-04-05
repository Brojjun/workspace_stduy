package com.ssafy.paging.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.paging.model.Board;
import com.ssafy.paging.model.Page;

public interface BoardService {
	public Map<String, Object> listBoard(Page page) throws Exception;
}