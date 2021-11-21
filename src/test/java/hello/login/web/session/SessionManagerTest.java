package hello.login.web.session;

import hello.login.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/11/21
 */
class SessionManagerTest {

    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest() {

        // 세션 생성
        final MockHttpServletResponse response = new MockHttpServletResponse();
        final var member = new Member();
        sessionManager.createSession(member, response);

        // 요청에 응답 쿠키 저장
        final MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        // 세션 조회
        final var result = sessionManager.getSession(request);
        assertThat(result).isEqualTo(member);

        // 세션 만료
        sessionManager.expire(request);
        final var expired = sessionManager.getSession(request);
        assertThat(expired).isNull();
    }
}
