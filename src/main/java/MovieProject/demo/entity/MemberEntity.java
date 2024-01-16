package MovieProject.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int member_idx;

    @Column
    private String member_id;

    @Column
    private String member_pw;

    @Column
    private String member_email;

    @Column
    private String member_name;

    @Enumerated(EnumType.STRING)
    private MemberRole member_role;

    public enum MemberRole{
        MEMBER_ADMIN , MEMBER_USER

    }
    @Builder
    public MemberEntity(String member_id, String member_pw, String member_email, String member_name, MemberRole member_role) {
        this.member_id = member_id;
        this.member_pw = member_pw;
        this.member_email = member_email;
        this.member_name = member_name;
        this.member_role = member_role;
    }
}