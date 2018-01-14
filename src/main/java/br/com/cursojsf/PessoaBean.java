package br.com.cursojsf;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

//import java.util.ArrayList;

//import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
//import javax.faces.component.html.HtmlCommandButton;

import br.com.dao.DaoGeneric;
import br.com.entidades.Pessoa;

@ManagedBean(name = "pessoaBean")
//@RequestScoped
@ViewScoped
//@SessionScoped
//@ApplicationScoped
public class PessoaBean {

	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public String salvar() {
		//daoGeneric.salvar(pessoa); //cria e salva um novo objeto
		//pessoa = new Pessoa();
		
		pessoa = (Pessoa) daoGeneric.merge(pessoa); //salva e atualiza e retorna o objeto
		carregarPessoas();
		
		return "";
	}
	
	public String novo(){
		pessoa = new Pessoa();
		
		return "";
	}
	
	public String remove() {
		daoGeneric.deletePorID(pessoa);
		carregarPessoas();
		
		return "";
	}
	
	@PostConstruct
	public void carregarPessoas() {
		pessoas = daoGeneric.getListEntity(Pessoa.class);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DaoGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
	
}
