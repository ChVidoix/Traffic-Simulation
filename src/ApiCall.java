import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;

public class ApiCall {
    public void call() throws IOException {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://community-open-weather-map.p.rapidapi.com/weather?units=%2522m"+"e"+"tric%2522&mode=JSON&q=Krakow")
//                .get()
//                .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
//                .addHeader("x-rapidapi-key", "6d4ce46db1mshfe089c60ff3f7d9p176410jsne78d142b5a5f")
//                .build();
//
//        Response response = client.newCall(request).execute();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://dark-sky.p.rapidapi.com/50.064651,19.944981,2020-05-30T16:00:00")
                .get()
                .addHeader("x-rapidapi-host", "dark-sky.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "6d4ce46db1mshfe089c60ff3f7d9p176410jsne78d142b5a5f")
                .build();

        Response response = client.newCall(request).execute();
        if(response.code() == 200){
            JsonReader reader = Json.createReader(response.body().byteStream());
            JsonObject obj = reader.readObject();
            reader.close();
            System.out.println(obj);
            System.out.println(obj.getJsonObject("currently").getString("icon"));
        } else {
            throw new Error("https://www.youtube.com/watch?v=Q8Afvt0o3yE");
        }
    }

    public static void main(String[] args) throws IOException {
        ApiCall call = new ApiCall();
        call.call();
        System.out.println(java.time.LocalDateTime.now().getHour());
    }
}
