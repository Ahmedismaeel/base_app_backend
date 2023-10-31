package com.mystoreapp.storeapp.src.controller;

import com.mystoreapp.storeapp.src.dto.OrderStatusDto;
import com.mystoreapp.storeapp.src.model.OrderStatus;
import com.mystoreapp.storeapp.src.repository.OrderStatusRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orderStatus")
@RequiredArgsConstructor
public class OrderStatusController {

    private final OrderStatusRepository orderStatusRepository;

    @PostMapping
    public ResponseEntity<?> createOrderStatus(@RequestBody @Valid OrderStatusDto request){
        orderStatusRepository.save(OrderStatus.builder()
                        .statusName(request.getTitle())
                .build());
      return  ResponseEntity.ok().body("success");
    }

    @GetMapping
    public  ResponseEntity<?> getAllStatus(){
        return ResponseEntity.ok(orderStatusRepository.findAll());
    }

    @PutMapping("/{statusId}")
    public ResponseEntity<?> updateStatus(@RequestBody @Valid OrderStatusDto request, @PathVariable long statusId){

        return  ResponseEntity.ok().body(orderStatusRepository.save(OrderStatus.builder()
                        .statusName(request.getTitle())
                        .id(statusId)
                .build()));
    }


}
