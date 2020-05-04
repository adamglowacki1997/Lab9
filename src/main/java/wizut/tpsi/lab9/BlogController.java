package wizut.tpsi.lab9;

import java.sql.SQLException;
import javax.activation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
     @Autowired
    private BlogRepository blogrepo; 
     
     
     @RequestMapping("/")
public String getPosts(Model model) throws SQLException 
{
    model.addAttribute("allPosts", blogrepo.getAllPosts());
    return "index";
}
     
     
     @PostMapping("/newpost")
public String newPost(BlogPost post) throws SQLException {
    blogrepo.createPost(post);
    return "redirect:/";
}
     
      @PostMapping("/removepost")
    public String removePost(BlogPost post) throws SQLException {
        blogrepo.removePost(post);
        return "redirect:/";
    }
     
}
