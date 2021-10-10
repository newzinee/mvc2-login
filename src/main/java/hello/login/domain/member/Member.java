package hello.login.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/10/10
 */
@Data
public class Member {

    private Long id;

    @NotEmpty
    private String loginId; // 로그인 ID

    @NotEmpty
    private String name;    // 사용자 이름

    @NotEmpty
    private String password;
}
