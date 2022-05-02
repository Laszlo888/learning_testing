import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface TodoService {
  // define request method and endpoint
  @GET("todos")
  // api call that result in a Java List<> with User type objects
  Call<List<Todo>> listTodos();
}
