package hellojpa.domain;

import javax.persistence.*;

@Entity
public class Locker {

    @Id@GeneratedValue
    @Column(name = "locker_id")
    private Long id;
/*
    @OneToOne(mappedBy = "locker")
    private Member member;*/
}
