package MovieProject.demo.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_idx;

    @Column
    private int member_idx; // 작성유저 인덱스 ( FK )

    @Column
    private String board_title;

    @Column
    private String board_contents;

    @Column
    private Date board_posttime;

    @Builder
    public BoardEntity(int member_idx, String board_title, String board_contents, Date board_posttime) {
        this.member_idx = member_idx;
        this.board_title = board_title;
        this.board_contents = board_contents;
        this.board_posttime = board_posttime;
    }
}
