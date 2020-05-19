package kakao;

import lombok.Getter;
import lombok.Setter;

//kakao token api 연동시 맵핑을 위한 모델 생성
@Getter
@Setter
public class RetKakaoAuth {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private long expires_in;
    private String scope;
}
