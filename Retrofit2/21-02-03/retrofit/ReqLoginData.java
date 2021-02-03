package retrofit;

// api/login 통신의 요청 객체 -> 로그인 POST 요청시 보낼 데이터
public class ReqLoginData {

    String email;
    String password;

    public ReqLoginData(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
