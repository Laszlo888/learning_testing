public class Todo {
  int userId;
  int id;
  String title;
  boolean completed;

  @Override
  public String toString() {
    return "Todo{"
        + "userId="
        + userId
        + ", id="
        + id
        + ", title='"
        + title
        + '\''
        + ", completed="
        + completed
        + '}';
  }
}
