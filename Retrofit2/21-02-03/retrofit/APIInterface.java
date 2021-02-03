package retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    // base_url + "api/login"으로 POST 통신
    @POST("api/login")
    // @Body : request 파라미터
    Call<ResLoginData> requestPostLogin(@Body ReqLoginData reqLoginData);

    // base_url + "api/users"으로 GET 통신
    @GET("api/users")
    // @Query : url에 쿼리 파라미터 추가
    Call<ResUsersData> requestGetUsersDetail(@Query(value="page", encoded = true) String page);
}
