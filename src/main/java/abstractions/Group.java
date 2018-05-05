package abstractions;

public class Group implements Model {

	private static String value = "hello";

	static {
		value = "new";
	}

	private Long id = 123L;
	private String name;
	{
		System.out.println(id); //123
	}

	public Group(String name) {
		this(null, name);
		System.out.println("in const");
	}

	public Group(Long id, String name) {
		this.setName(name);
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public Group setName(String name) {
		this.name = name;
		return this;
	}


	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("[%s, %s]", getId(), getName());
	}

}
