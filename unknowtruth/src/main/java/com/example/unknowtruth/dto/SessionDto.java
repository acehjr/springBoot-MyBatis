package com.example.unknowtruth.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: hjr
 * @Date: 2019/2/18 10:36
 */
@Setter
@Getter
@ToString
public class SessionDto implements Serializable {
    private static final long serialVersionUID = -1L;

    private Long userId;

    //不要在JWT放敏感信息，因为加密的JWT拿到https://jwt.io/就能破解出来，所以说整个JWT的安全重点是JWTConstant的JWT_SECRET，用它来验证，这是“没被篡改过的”
    //其它信息。。。
}
