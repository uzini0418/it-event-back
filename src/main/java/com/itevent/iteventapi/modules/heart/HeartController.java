package com.itevent.iteventapi.modules.heart;

import com.itevent.iteventapi.common.response.JsonResponse;
import com.itevent.iteventapi.modules.account.Account;
import com.itevent.iteventapi.modules.account.CurrentAccount;
import com.itevent.iteventapi.modules.heart.dto.HeartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class HeartController {

    private final HeartService heartService;

    // TODO: targetId Valid Check

    @PostMapping("/heart")
    public ResponseEntity<JsonResponse> addHeart(@CurrentAccount Account account, @Valid @RequestBody HeartDto heartDto) {
        heartService.createHeart(heartDto, account);
        return new ResponseEntity<JsonResponse>(new JsonResponse(), HttpStatus.OK);
    }

}
