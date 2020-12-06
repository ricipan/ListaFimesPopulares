package data.network;

import okhttp3.ResponseBody;
import response.FilmesResult;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {
    @GET("movie/popular")
    Call<FilmesResult> aobterFilmesPopulares(@Query("api_key") String chaveApi);
}
