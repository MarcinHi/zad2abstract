package abstractions;

import java.util.List;

public interface DaoInterface<T extends Model> {

	public List<T> loadAll();

	public T loadById(int id);

	public void save(T object);

	public void delete(T object);

}
