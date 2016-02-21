package model;

public class Usuario {
	private String login;
	private String senha;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "{\n"
				+ "\t\"login\":\"" + getLogin() + "\",\n"
				+ "\t\"senha\":\"" + getSenha() + "\"\n"
				+ "}";
	}
}
