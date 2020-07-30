package br.com.codenation;


import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	public List<Team> teams = new ArrayList<>();
	public List<Player> players = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (teams.stream().anyMatch(t -> t.getId() == id))
			throw new IdentificadorUtilizadoException();

		teams.add(new Team(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(players.stream().anyMatch(j -> j.getId() == id))
			throw new IdentificadorUtilizadoException();

		if(teams.stream().noneMatch(team -> team.getId() == idTime))
			throw new TimeNaoEncontradoException();

		players.add(new Player(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	public void definirCapitao(Long idJogador) {
		if (players.stream().noneMatch(player -> player.getId() == idJogador))
			throw new JogadorNaoEncontradoException();

		Long idTime = players.stream().filter(player -> player.getId() == idJogador).findFirst().get().getIdTeam();

		teams.stream().filter(team -> team.getId() == idTime).findFirst().get().setCaptain(idJogador);
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		if (teams.stream().noneMatch(team -> team.getId() == idTime))
			throw new TimeNaoEncontradoException();

		if(teams.stream().filter(team -> team.getId() == idTime).findFirst().get().getCaptain() == null)
			throw new CapitaoNaoInformadoException();

		return teams.stream().filter(team -> team.getId() == idTime).findFirst().get().getCaptain();
	}

	public String buscarNomeJogador(Long idJogador) {
		if (players.stream().noneMatch(player -> player.getId() == idJogador))
			throw new JogadorNaoEncontradoException();

		return players.stream().filter(player -> player.getId() == idJogador).findFirst().get().getName();
	}

	public String buscarNomeTime(Long idTime) {
		if (teams.stream().noneMatch(team -> team.getId() == idTime))
			throw new TimeNaoEncontradoException();

		return teams.stream().filter(team -> team.getId() == idTime).findFirst().get().getName();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if (teams.stream().noneMatch(team -> team.getId() == idTime))
			throw new TimeNaoEncontradoException();

		return players.stream().filter(player -> player.getIdTeam() == idTime).map(p -> p.getId()).sorted().collect(Collectors.toList());
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if (teams.stream().noneMatch(team -> team.getId() == idTime))
			throw new TimeNaoEncontradoException();

		return players.stream().filter(player -> player.getIdTeam() == idTime).max(Comparator.comparing(Player::getSkillLevel)).get().getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if (teams.stream().noneMatch(team -> team.getId() == idTime))
			throw new TimeNaoEncontradoException();

		return players.stream().filter(player -> player.getIdTeam() == idTime).min(Comparator.comparing(Player::getBirthDate).thenComparing(Player::getId)).get().getId();
	}

	public List<Long> buscarTimes() {
		return teams.stream().map(Team::getId).sorted().collect(Collectors.toList());
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if (teams.stream().noneMatch(team -> team.getId() == idTime))
			throw new TimeNaoEncontradoException();

		return players.stream().filter(player -> player.getIdTeam() == idTime).sorted(Comparator.comparing(Player::getSalary).reversed().thenComparing(Player::getId)).findFirst().get().getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if (players.stream().noneMatch(player -> player.getId() == idJogador))
			throw new JogadorNaoEncontradoException();

		return players.stream().filter(player -> player.getId() == idJogador).findFirst().get().getSalary();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		return players.stream().sorted(Comparator.comparing(Player::getSkillLevel).reversed()).map(p -> p.getId()).limit(top).collect(Collectors.toList());

	}

}