package com.spring.week04.service;

import com.spring.week04.models.ItemDto;
import com.spring.week04.models.Product;
import com.spring.week04.models.ProductMyPriceRequestDto;
import com.spring.week04.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMyPriceRequestDto requestDto){
        // orElseThrow 처리 해줌으로써 예외 상황이 아니면 Product 타입임이 명시됨
        // 없다면 Optinal 타입으로 반환 됨 (못 찾을 경우 Null이기 때문!)
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        product.update(requestDto);
        return id;
    }

    @Transactional
    public Long updateBySearch(Long id, ItemDto itemDto){
        Product product = productRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        product.updateByItemDto(itemDto);
        return id;
    }

    @Transactional
    public Long updateMyPrice(Long id, ProductMyPriceRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("올바른 접근이 아닙니다.")
        );
        product.updateMyPrice(requestDto);
        return id;
    }
}
