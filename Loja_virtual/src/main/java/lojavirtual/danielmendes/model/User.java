package lojavirtual.danielmendes.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//OBS, não sei por que, mas se tentarmos criar uma tabela com o nome de User, dá problema
@Entity
@Table(name = "users")
@SequenceGenerator(name = "seq_users", sequenceName = "seq_users", allocationSize = 1, initialValue = 1)

public class User implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
	private Long id;
	
	@Column(nullable = false)
	private String login;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date password_Date;
	
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
	private Person person;
	
	// o Flyway possibilita alterar SQL
	
	/*ctrl+space abre as possibilidades do que você está digitando*/
	//mapeamento das chaves em ROLES
	@OneToMany(fetch = FetchType.LAZY) //só carrega quando precisar
	@JoinTable(name = "user_roles", uniqueConstraints = @UniqueConstraint (columnNames = {"user_id", "role_id"} , 
	 	name = "unique_user_roles"),
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", table = "users",
		unique = false, foreignKey = @ForeignKey(name = "user_fk", value = ConstraintMode.CONSTRAINT)), 
		inverseJoinColumns = @JoinColumn(name = "role_id", unique = false, referencedColumnName = "id", table = "roles",
		foreignKey = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)))
	private List<Roles> roles;
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	//Autoridades = São os acessos ROLE_ADMIN, ROLE_SECRETARIO, ROLE_FINANCEIRO
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.roles;
	}

	@Override
	public String getPassword() {
	
		return this.password;
	}

	@Override
	public String getUsername() {
		
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
