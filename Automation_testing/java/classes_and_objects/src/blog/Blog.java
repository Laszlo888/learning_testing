package blog;

import blogpost.BlogPost;

import java.util.ArrayList;
import java.util.List;

public class Blog {

  // Reuse your BlogPost class
  // Create a Blog class which can:
  // store a list of BlogPosts
  // and has the following methods:
  // add(BlogPost) -> adds a BlogPost to the list
  // delete(int) -> deletes the BlogPost from the given index
  // update(int, BlogPost) -> replaces an item at the given index with a new BlogPost

  List<BlogPost> bl = new ArrayList<>();

    void add(BlogPost blogpost){
        bl.add(blogpost);
    }

    void delete(int number){
        bl.remove(number);
    }

    void update(int number, BlogPost blogpost){
        bl.set(number,blogpost);
    }
}
