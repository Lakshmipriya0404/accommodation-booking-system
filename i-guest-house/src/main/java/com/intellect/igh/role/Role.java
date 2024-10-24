/**
 * 
 */
package com.intellect.igh.role;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intellect.igh.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author lakshmipriya.ramesh
 *
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="role")
//@EntityListeners(AuditingEntityListener.class)
public class Role {
	
	@Id
    private Integer id;

    @Column(unique = true)
    private String name;
	
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private List<User> users;	
	
}
