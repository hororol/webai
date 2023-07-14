package com.jpa.jpa.service;

import com.jpa.jpa.dto.FreeBoardDto;
import com.jpa.jpa.entity.FreeBoard;
import com.jpa.jpa.repository.FreeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // service는 객체등록을 해주어야한다.
public class FreeBoardService {

    @Autowired
    FreeBoardRepository freeBoardRepository;

    public List<FreeBoardDto> list() {
        // 데이터베이스에 가서 select 해서 내용을 가지고 온 다음 list에 담는다.
        // 컬렉션과 제네릭(list, Map, Set) 컬렉션은 자료형
        // Page <-> List (page와 list는 동일하다)
        Page<FreeBoard> pagelist = freeBoardRepository.findAll(PageRequest.of(0,5)); // PageRequest.of(0,5) : 0페이지에 5개씩 -> 0페이지부터 늘어난다.
        // list에 담긴 FreeBoard를 FreeBoardDto로 변경해서 list에 다시 담는다.
        List<FreeBoardDto> dtolist = new ArrayList<>();
        for(FreeBoard fb : pagelist){
            FreeBoardDto dto = FreeBoardDto.of(fb);
            dtolist.add(dto);
        }
        System.out.println("page = " + dtolist);
        return dtolist;
    }
}
