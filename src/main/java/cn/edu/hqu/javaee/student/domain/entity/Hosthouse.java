package cn.edu.hqu.javaee.student.domain.entity;

import java.util.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class Hosthouse {
	
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String hosthouse;
	
	@Getter
	@Setter
	private String address;
	
	@Getter
	@Setter
	private String type;
	
	@Getter
	@Setter
	private Long money;
	
	@Getter
	@Setter
	private Long people;
	
	@Getter
	@Setter
	private String rent;
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this,that,"address","type","people","money","id","rent");
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "address","type","people","money","id","rent");
	}

}
