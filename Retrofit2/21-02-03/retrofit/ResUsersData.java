package retrofit;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

// api/users 응답 데이터 -> 유저 GET 요청에 대한 응답 객체
// 통신 결과 값을 ResUsersData 객체에 매핑함
public class ResUsersData {

    // GSON 이란, 자바 객체와 JSON간의 직렬화 및 역직렬화를 위한 오픈소스 라이브러리
    // JSON자체의 파싱보다는 업무로직 자체에 집중할 수 있도록 도와줌

    // JSON의 key 이름이 class의 변수 이름과 동일해야함
    @Expose
    int page;

    @Expose
    @SerializedName("per_page") // JSON의 key 이름이 한글이거나, 변수명으로 할 수 없는 경우 매핑시켜줌
   int perPage;

    @Expose
    int total;

    @Expose
    @SerializedName("total_pages")
    int totalPages;

    @Expose
    List<Data> data;

    public class Data{

        int id;
        String email;

        @SerializedName("first_name")
        String firstName;

        @SerializedName("last_name")
        String lastName;

        String avatar;

        @NonNull

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", email='" + email + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }
    }



    @Override
    public String toString() {
        String str = "[ResUsersData] page=" + page + " , perPage=" + perPage + " , total=" + total + " , totalPages=" + totalPages + " , data= [";
        for( int i=0; i<data.size(); i++ ) {
            str += data.get(i).toString();
            if( i < data.size()-1 ) {
                str += ",";
            }
        }
        str += "]";

        return str;
    }
}

/* 데이터 형식

{
"page": 1,
"per_page": 6,
"total": 12,
"total_pages": 2,
"data":[
{"id": 1, "email": "george.bluth@reqres.in", "first_name": "George", "last_name": "Bluth",…},
{"id": 2, "email": "janet.weaver@reqres.in", "first_name": "Janet", "last_name": "Weaver",…},
{"id": 3, "email": "emma.wong@reqres.in", "first_name": "Emma", "last_name": "Wong",…},
{"id": 4, "email": "eve.holt@reqres.in", "first_name": "Eve", "last_name": "Holt",…},
{"id": 5, "email": "charles.morris@reqres.in", "first_name": "Charles", "last_name": "Morris",…},
{"id": 6, "email": "tracey.ramos@reqres.in", "first_name": "Tracey", "last_name": "Ramos",…}
],
"support":{
"url": "https://reqres.in/#support-heading",
"text": "To keep ReqRes free, contributions towards server costs are appreciated!"
}

*/
