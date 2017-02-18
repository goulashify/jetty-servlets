package com.danigu.blog.post.persistence;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * Implementation-detail of the database, represented as {@link PostDTO} to the outside world.
 * @author dani
 */
@Data
@Entity(name = "post")
@Table(name = "post")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class PostEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String content;

//    @OneToMany(targetEntity = CommentEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//    private List<CommentEntity> comments;
}