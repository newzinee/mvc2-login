package hello.login.web.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/10/11
 */
@Data
public class LoginForm {

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;
}
