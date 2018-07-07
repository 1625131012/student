package cn.edu.hqu.javaee.student.domain.entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.web.multipart.MultipartFile;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Host {
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=30,message="{firstName.size}")
	private String firstName;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=5,max=16,message="{userNamehou.size}")
	private String userNamehou;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=25,message="{passwordhou.size}")
	private String passwordhou;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=30,message="{lastName.size}")
	private String lastName;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=30,message="{phonehou.size}")
	private String phonehou;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=100,message="{address.size}")
	private String address;
	
	
	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, that, "firstName","lastName","phonehou","address","userNamehou","passwordhou");
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "firstName","lastName","phonehou","address","userNamehou","passwordhou");
	}
}
