package com.itevent.iteventapi.modules.event;

import com.itevent.iteventapi.common.response.JsonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EventController {

    @GetMapping("/events/{id}")
    public ResponseEntity<JsonResponse> getEvent(@PathVariable Long id) {

        Event event = new Event();
        event.setId(1L);
        event.setTitle("이벤트 타이틀 테스트");

        System.out.println("event get");

        return new ResponseEntity<JsonResponse>(new JsonResponse(event), HttpStatus.OK);
    }

    @PostMapping("/events")
    public ResponseEntity<JsonResponse> addEvent(@RequestBody Event event) {
        System.out.println("event 생성");
        System.out.println(event.toString());

        return new ResponseEntity<JsonResponse>(new JsonResponse(event), HttpStatus.OK);
    }

    @PatchMapping("/events")
    public ResponseEntity<JsonResponse> updateEvent(@RequestBody Event event) {
        System.out.println("event 업데이트");

        return new ResponseEntity<JsonResponse>(new JsonResponse(event), HttpStatus.OK);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<JsonResponse> deleteEvent(@PathVariable Long id) {
        System.out.println("event 삭제");

        return new ResponseEntity<JsonResponse>(new JsonResponse(), HttpStatus.OK);
    }
}