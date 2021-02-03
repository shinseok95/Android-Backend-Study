package retrofit;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;

// api/login 응답 데이터 -> 로그인 POST 요청시 응답받을 객체
// 통신 결과 값을 ResLoginData 객체에 매핑함
public class ResLoginData {

    //@Expose : object 중 해당 값이 null일 경우, json으로 만들 필드를 자동 생략
    @Expose
    String token;

    @NonNull
    @Override
    public String toString() {
        return "ResLoginData{" +
                "token='" + token + '\'' +
                '}';
    }
}
