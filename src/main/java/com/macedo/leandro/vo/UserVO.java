package com.macedo.leandro.vo;

import com.macedo.leandro.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserVO {
    private User user;
    private boolean isValid;

    public UserVO(boolean isValid) {
        this.isValid = isValid;
    }
}
