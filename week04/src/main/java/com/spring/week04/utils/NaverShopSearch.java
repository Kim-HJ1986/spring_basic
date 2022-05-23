package com.spring.week04.utils;

import com.spring.week04.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaverShopSearch {
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "5D0hMbBl9NDCEY3QS0kF");
        headers.add("X-Naver-Client-Secret", "mbVpPwmdFb");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public static List<ItemDto> fromJSONtoItems(String result){
        // Java String을 Json 객체로 바꿔준다.
        JSONObject rjson = new JSONObject(result);

        // JSON 객체에서 JSON 배열(대괄호)을 꺼내준다.
        JSONArray items = rjson.getJSONArray("items");

        // for문 돌며 JSON객체로 뽑아오기
        List<ItemDto> itemDtoList = new ArrayList<>();
        for(int i=0; i<items.length(); i++){
            //JSONArray에 담겨있는 JsonObject를 가져오겠다.
            JSONObject itemJson = items.getJSONObject(i);
            ItemDto itemDto = new ItemDto(itemJson);
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }
}