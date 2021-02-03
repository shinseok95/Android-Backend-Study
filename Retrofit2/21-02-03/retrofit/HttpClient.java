package retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

    private static String baseUrl = "https://reqres.in/";
    private static Retrofit retrofit;

    // 싱글톤으로 Retrofit 객체 생성
    public static Retrofit getRetrofit(){

        if(retrofit == null){

            // retrofit builder 객체 생성
            Retrofit.Builder builder = new Retrofit.Builder();

            // base url 설정
            builder.baseUrl(baseUrl);

            // 받아오는 json 구조의 데이터를 객체 형태로 변환
            builder.addConverterFactory(GsonConverterFactory.create());

            retrofit = builder.build();
        }

        return retrofit;
    }
}

