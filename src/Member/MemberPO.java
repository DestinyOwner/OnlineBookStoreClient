package Member;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class MemberPO implements Serializable {
	private int memberID;
	private String name;
	private String password;
	private String phone;
	private Calendar birth;
	private long integral;

	public MemberPO(int memberID, String name, String password, String phone,
			Calendar birth) {
		super();
		this.memberID = memberID;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.birth = birth;
	}

	public int getID() {
		return memberID;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public Calendar getBirth() {
		return birth;
	}

	public long getIntegral() {
		return integral;
	}
}
