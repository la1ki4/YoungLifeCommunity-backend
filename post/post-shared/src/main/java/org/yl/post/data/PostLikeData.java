package org.yl.post.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostLikeData {
    long likeAmount;
}
