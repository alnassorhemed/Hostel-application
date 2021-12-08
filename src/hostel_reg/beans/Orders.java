package hostel_reg.beans;

public class Orders {
	private int id;
	private String name;
	private String date;
	private String blocks;
	private int room;
	private String residence;
	private String disability;
	private int period;
	
	public Orders(int id,String name, String date, String blocks, int room,String residence, String disability,int period) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.blocks = blocks;
		this.room = room;
		this.residence = residence;
		this.disability = disability;
		this.period = period;
	}

	public Orders() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNames() {
		return name;
	}

	public void setNames(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBlock() {
		return blocks;
	}

	public void setBlock(String blocks) {
		this.blocks = blocks;
	}

	public int getRoomNo() {
		return room;
	}

	public void setRoomNo(int room) {
		this.room = room;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence=residence;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}
	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

}
