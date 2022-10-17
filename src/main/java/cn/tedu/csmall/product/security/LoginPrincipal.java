package cn.tedu.csmall.product.security;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginPrincipal implements Serializable {
    private Long id;
    private String username;
}
