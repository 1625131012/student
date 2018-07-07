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
public class Student {
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=30,message="{firstName.size}")
	private String firstName;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=5,max=16,message="{userNamestu.size}")
	private String userNamestu;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=25,message="{passwordstu.size}")
	private String passwordstu;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=30,message="{lastName.size}")
	private String lastName;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=30,message="{phonehou.size}")
	private String phonestu;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=100,message="{address.size}")
	private String address;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=20,message="{birthday.size}")
	private String birthday;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=10,message="{sex.size}")
	private String sex;
	
	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, that, "firstName","lastName","address_stu","phonestu","birthday","sex","userNamestu","passwordstu");
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "firstName","lastName","address_stu","phonestu","birthday","sex","userNamestu","passwordstu");
	}
}
