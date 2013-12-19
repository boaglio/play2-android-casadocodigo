package com.boaglio.casadocodigo.play.top100filmescultmobile;

public class Filme {

	public Long id;

	public String nome;

	public String tipo;

	public Double nota;

	public Integer duracao;

	public Integer ano;

	public String genero;

	public Integer votos;

	public String url;

	public Diretor diretor;

	@Override
	public String toString() {
		return nome;
	}

}
