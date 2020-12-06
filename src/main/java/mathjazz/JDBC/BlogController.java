package mathjazz.JDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;
    
    @GetMapping("/")
    public String showPost(Model model) throws SQLException  {
        List<BlogPost> posts = blogRepository.getAllPosts();
        model.addAttribute("posts", posts);
        
        return "home";
    }
    
    @PostMapping("/newpost")
    public String newPost(BlogPost post) throws SQLException {
        blogRepository.createPost(post);
        return "redirect:/";
        
    }
    
    @PostMapping("/removepost")
    public String removePost(BlogPost post) throws SQLException {
        blogRepository.deletePost(post);
        return "redirect:/";
        
    }
    
}
