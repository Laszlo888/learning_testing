import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class Main {
  // Given the command line open
  // And the current working diretory project root
  // When the application is run without arguments
  // Then usage information is printed

  // Given the command line open
  // And the current working diretory project root
  // When the application is run with the 'todo' argument
  // Then non completed todos are printed to the console

  // Given the command line open
  // And the current working diretory project root
  // When the application is run with the 'done' argument
  // Then completed todos are printed to the console

  public static void main(String[] args) throws IOException {
    // setup Retrofit
    Retrofit retrofit =
        new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    TodoService service = retrofit.create(TodoService.class);

    // define the call to JsonPlaceholder
    Call<List<Todo>> todoCall = service.listTodos();

    // get the list of users
    List<Todo> todos = todoCall.execute().body();

    if (args.length == 0) {
      System.out.println(
          "\nUsage information:\ngradlew run --args='todo' (will print not completed todos)\n"
              + "gradlew run --args='done' (will print completed todos)\n");
    }
    if (args[0].equals("todo")) {
      for (Todo t : todos) {
        if (t.completed == false) {
          System.out.println(t);
        }
      }
    }
    if (args[0].equals("done")) {
      for (Todo t : todos) {
        if (t.completed) {
          System.out.println(t);
        }
      }
    }
  }
}
