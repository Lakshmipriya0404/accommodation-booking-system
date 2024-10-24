/**
 * 
 */
package com.intellect.igh.user;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.intellect.igh.booking.Booking;
import com.intellect.igh.role.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author lakshmipriya.ramesh
 *
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="_user")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal{
	
	@Id
	private String assoId;
	private String assoLevel;
	private String firstName;
	private String lastName;
	
	@Column(unique = true)
	private String email;
	private String password;
	private long mobileNumber;
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
	
	@OneToMany(mappedBy = "bookedBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookingsByUser;
	
	@OneToMany(mappedBy = "bookedTo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookingsToUser;

	public String fullName() {
		// TODO Auto-generated method stub
		return firstName + " " + lastName;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles
				.stream()
				.map(r-> new SimpleGrantedAuthority(r.getName()))
				.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return email;
	}
	
}
