package listafilmes;

import java.util.List;

import data.network.ApiService;
import mapper.FilmeMapper;
import model.Filme;
import response.FilmesResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter {

    private ListaFilmesContrato.ListaFilmesView view;

    public ListaFilmesPresenter(ListaFilmesContrato.ListaFilmesView view) {
        this.view = view;
    }

    @Override
    public void obtemFilmes() {
        ApiService.getInstance().aobterFilmesPopulares("bea67ad6f41b66e925282dd7856e0e5b").enqueue(new Callback<FilmesResult>() {
            @Override
            public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {
                if (response.isSuccessful()) {
                    final List<Filme> listaFilmes = FilmeMapper.deResponseParaDominio(response.body().getResultadoFilmes());

                    view.mostraFilmes(listaFilmes);
                } else {
                    view.mostraErro();
                }

            }

            @Override
            public void onFailure(Call<FilmesResult> call, Throwable t) {
                view.mostraErro();

            }
        });


    }

    @Override
    public void destruirView() {
        this.view =null;
    }
}
