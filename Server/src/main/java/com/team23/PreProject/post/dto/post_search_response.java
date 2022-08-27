package com.team23.PreProject.post.dto;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public class post_search_response {
    //answer + post union 수행한 테이블에서 검색 수행 -> 페이지네이션 적용
    //db에서 like 이용 하여 쿼리 수행
    //
    int posts;
    String searchInput;
    Pageable pageInfo;
    ArrayList<post_information> postInformationList;
    String sortParameter;

}
