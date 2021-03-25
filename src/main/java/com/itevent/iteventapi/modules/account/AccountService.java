package com.itevent.iteventapi.modules.account;

import com.itevent.iteventapi.modules.account.dto.AccountJoinDto;
import com.itevent.iteventapi.modules.account.dto.AccountResDto;
import com.itevent.iteventapi.modules.account.dto.AccountUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AccountResDto createAccount(AccountJoinDto accountJoinDto) {
        Account account = saveNewAccount(accountJoinDto);

        return AccountResDto.of(account);
    }

    private Account saveNewAccount(AccountJoinDto accountJoinDto) {
        accountJoinDto.setPassword(passwordEncoder.encode(accountJoinDto.getPassword()));
        Account account = Account.of(accountJoinDto);
        accountRepository.save(account);

        return account;
    }

    public AccountResDto getAccount(String nickname) {
        Account account = getAccountAndExistCheck(nickname);
        return AccountResDto.of(account);
    }

    public AccountResDto updateAccount(String nickname, AccountUpdateDto accountUpdateDto) {
        Account account = getAccountAndExistCheck(nickname);
        return AccountResDto.of(account);
    }

    private Account getAccountAndExistCheck(String nickname) {
        Account account = accountRepository.findByNickname(nickname);
        if(account == null) {
            throw new IllegalArgumentException("요청한 계정이 없습니다. [nickname : " + nickname + "]");
        }
    }

}