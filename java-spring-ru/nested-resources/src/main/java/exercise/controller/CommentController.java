package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    // BEGIN
    @GetMapping(path = "/{postId}/comments")
    public Iterable<Comment> getAllCommentsByPostId(@PathVariable Long postId) {
        return this.commentRepository.findAllByPostId(postId);
    }

    @GetMapping(path = "/{postId}/comments/{commentId}")
    public Comment getCommentById(@PathVariable("postId") Long postId,
                                            @PathVariable("commentId") Long commentId) {
        return this.commentRepository.findByIdAndPostId(commentId, postId)
                .orElseThrow(()
                        -> new ResourceNotFoundException("Post" + postId + "or Comment" + commentId + "not found"));
    }

    @PostMapping(path = "/{postId}/comments")
    public  Iterable<Comment> createCommentByPost(@PathVariable Long postId, @RequestBody Comment comment) {
//        Comment commentNew = commentRepository.save(comment);
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post" + postId +"not found"));
        comment.setPost(post);
        commentRepository.save(comment);
        return this.commentRepository.findAllByPostId(postId);
    }
    @PatchMapping(path = "/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable("postId") Long postId,
                              @PathVariable("commentId") Long commentId, @RequestBody Comment comment) {
        if (!commentRepository.existsById(commentId)) {
            throw new ResourceNotFoundException("Comment not found");
        }
        comment.setId(commentId);
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post" + postId +"not found"));
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    @DeleteMapping(path = "/{postId}/comments/{commentId}")
    public void deleteComment(@PathVariable("postId") Long postId,
                              @PathVariable("commentId") Long commentId) {
        Comment comment = commentRepository.findByIdAndPostId(commentId, postId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));

        commentRepository.delete(comment);
    }
    // END
}
