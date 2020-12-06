package listafilmes;

import java.util.List;

import model.Filme;

public interface ListaFilmesContrato {

    interface ListaFilmesView {

        void mostraFilmes(List<Filme> filmes);

        void mostraErro();

    }

    interface ListaFilmesPresenter {

        void obtemFilmes();

        void destruirView();

    }
}
